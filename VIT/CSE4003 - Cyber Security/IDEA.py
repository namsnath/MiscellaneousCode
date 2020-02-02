import math

def hexToBinaryFill(hex_str, fill=128):
	return bin(int(hex_str, 16))[2:].zfill(fill)

def decimalToBinaryFill(decimal, fill=8):
	if decimal >= 0:	# For positive numbers
		return bin(decimal)[2:].zfill(fill)
	else:				# 2's complement binary for negative numbers
		return bin(decimal & int('0b' + '1' * 16, 2))[2:].zfill(fill)

def asciiToDecimalList(text):
	return [ord(i) for i in text.upper()]

def binaryToDecimalList(bin_str):
	bit_groups = [bin_str[i: i+8] for i in range(0, len(bin_str), 8)]
	return [int(i, 2) for i in bit_groups]

def binaryToDecimal(bin_str):
	return int(bin_str, 2)

def binaryToHexFill(bin_str, fill=4):
	return hex(int(bin_str, 2))[2:].zfill(4)

def printHexAndBinary(bin_str):
	bit_groups = [bin_str[i: i+4] for i in range(0, len(bin_str), 4)]
	for i in range(0, len(bit_groups), 4):
		bin_group = ''.join(bit_groups[i: i+4])
		hex_group = hex(int(bin_group, 2))[2:]

		print(bit_groups[i: i+4], hex_group)

def rotate(bin_str):
	return bin_str[25:] + bin_str[: 25]

def addModulo(bin_1, bin_2):
	return decimalToBinaryFill((int(bin_1, 2) + int(bin_2, 2)) % 2**16, 16)

def multModulo(bin_1, bin_2):
	if int(bin_1, 2) == 0:
		bin_1 = decimalToBinaryFill(2**16, 16)

	if int(bin_2, 2) == 0:
		bin_2 = decimalToBinaryFill(2**16, 16)

	if int(bin_1, 2) == 2**16:
		bin_1 = '0' * len(bin_1)

	if int(bin_2, 2) == 2**16:
		bin_2 = '0' * len(bin_2)

	return decimalToBinaryFill((int(bin_1, 2) * int(bin_2, 2)) % (2**16 + 1), 16)

def bitwiseXOR(bin_1, bin_2):
	return decimalToBinaryFill(int(bin_1, 2) ^ int(bin_2, 2), 16)

def modInv(a):
	a = int(a, 2)
	b = int('10001', 16)	# 65537
	u = 0
	v = 1

	while a > 0:
		q = math.floor(b / a)
		r = b % a

		b, a = a, r

		t = v
		v = u - q * v
		u = t

	if u < 0:
		u += int('10001', 16)

	return decimalToBinaryFill(u, 16)

def keygen(hex_key):
	keys128 = []
	enc_keys = []
	dec_keys = [None for i in range(52)]
	bin_str = hexToBinaryFill(hex_key)

	keys128.append(bin_str)
	for i in range(6):
		bin_str = rotate(bin_str)
		keys128.append(bin_str)

	for i in keys128:
		bin_keys = [i[j: j+16] for j in range(0, len(i), 16)]
		enc_keys = [*enc_keys, *bin_keys]

	# Output is 56 keys, we need 52
	enc_keys = enc_keys[:52]

	for i in range(0, 52, 6):
		dec_keys[i] = modInv(enc_keys[48 - i])

		if i == 0 or i == 48:
			dec_keys[i + 1] = decimalToBinaryFill(-binaryToDecimal(enc_keys[49 - i]), 16)
			dec_keys[i + 2] = decimalToBinaryFill(-binaryToDecimal(enc_keys[50 - i]), 16)
		else:
			dec_keys[i + 1] = decimalToBinaryFill(-binaryToDecimal(enc_keys[50 - i]), 16)
			dec_keys[i + 2] = decimalToBinaryFill(-binaryToDecimal(enc_keys[49 - i]), 16)

		dec_keys[i + 3] = modInv(enc_keys[51 - i])

		if i < 48:
			dec_keys[i + 4] = enc_keys[46 - i]
			dec_keys[i + 5] = enc_keys[47 - i]		

	print("Encryption Keys:")
	print("#, Binary, Hex")
	for i in range(len(enc_keys)):
		print(i+1, enc_keys[i], binaryToHexFill(enc_keys[i]))	

	print("\n\nDecryption Keys:")
	print("#, Binary, Hex")
	for i in range(len(dec_keys)):
		print(i+1, dec_keys[i], binaryToHexFill(dec_keys[i]))

	return enc_keys, dec_keys

def ideaRound(bin_plaintext, keys):
	plaintext_blocks = [bin_plaintext[i: i+16] for i in range(0, len(bin_plaintext), 16)]
	op = []
	steps = ['' for i in range(10)]

	steps[0] = multModulo(plaintext_blocks[0], keys[0])		# P1 * K1
	steps[1] = addModulo(plaintext_blocks[1], keys[1])		# P2 + K2
	steps[2] = addModulo(plaintext_blocks[2], keys[2])		# P3 + K3
	steps[3] = multModulo(plaintext_blocks[3], keys[3])  	# P4 * K4
	steps[4] = bitwiseXOR(steps[0], steps[2])				# Step1 XOR Step 3
	steps[5] = bitwiseXOR(steps[1], steps[3])				# Step2 XOR Step 4
	steps[6] = multModulo(steps[4], keys[4])				# Step5 * K5
	steps[7] = addModulo(steps[5], steps[6])				# step6 + step7
	steps[8] = multModulo(steps[7], keys[5])				# step8 * K6
	steps[9] = addModulo(steps[6], steps[8])				# step7 + step9

	op.append(bitwiseXOR(steps[0], steps[8]))				# Step1 XOR Step9
	op.append(bitwiseXOR(steps[2], steps[8]))				# Step3 XOR Step9
	op.append(bitwiseXOR(steps[1], steps[9]))				# Step2 XOR Step10
	op.append(bitwiseXOR(steps[3], steps[9]))				# Step4 XOR Step10

	for i in range(10):
		print('step' + str(i+1), steps[i])

	for i in range(4):
		print('C' + str(i+1), op[i])

	return ''.join(op)


def halfRound(bin_plaintext, keys):
	plaintext_blocks = [bin_plaintext[i: i+16] for i in range(0, len(bin_plaintext), 16)]
	op = []

	op.append(multModulo(plaintext_blocks[0], keys[0]))  	# P1 * K1
	op.append(addModulo(plaintext_blocks[2], keys[1]))		# P3 + K2
	op.append(addModulo(plaintext_blocks[1], keys[2]))		# P2 + K3
	op.append(multModulo(plaintext_blocks[3], keys[3]))  	# P4 * K4

	for i in range(4):
		print('C' + str(i+1), op[i])

	return ''.join(op)

hex_key = "11225577AABBCCDDEEFF3344668899AA"
plaintext = "NEXTMOVE"
enc_keys, dec_keys = keygen(hex_key)
plaintext_bin = ''.join([decimalToBinaryFill(i) for i in asciiToDecimalList(plaintext)])

print("\nPlaintext: " + plaintext)
print("\nPlaintext Decimal:")
print(asciiToDecimalList(plaintext))
print("\nPlaintext Binary: " + plaintext_bin)

print("\nKey: " + hex_key)
print("\nKey Binary: " + hexToBinaryFill(hex_key))

print("\n\n")

intermediate_bin = plaintext_bin
for i in range(8):
	print('Round', i+1)
	keyIndex = i*6
	intermediate_bin = ideaRound(intermediate_bin, enc_keys[keyIndex:keyIndex+6])
	print()

print('Final Half-Round')
ciphertext_bin = halfRound(intermediate_bin, enc_keys[48:52])

print()
print("\nCiphertext Binary: " + ciphertext_bin)

print("\nCiphertext Decimal")
print(binaryToDecimalList(ciphertext_bin))

print("\nCiphertext ASCII")
print([chr(i) for i in binaryToDecimalList(ciphertext_bin)])

print('\n\nSTARTING DECRYPTION');
intermediate_bin = ciphertext_bin

for i in range(8):
	print('Round', i+1)
	keyIndex = i*6
	roundKeys = dec_keys[keyIndex:keyIndex+6]
	intermediate_bin = ideaRound(intermediate_bin, roundKeys)
	print()

print('Final Half-Round')
deciphered_text_bin = halfRound(intermediate_bin, dec_keys[48:52])

print()
print("\nDeciphered Binary: " + deciphered_text_bin)

print("\nDeciphered Decimal")
print(binaryToDecimalList(deciphered_text_bin))

print("\nDeciphered ASCII")
print([chr(i) for i in binaryToDecimalList(deciphered_text_bin)])

print('\nDeciphered String:', ''.join(
	[chr(i) for i in binaryToDecimalList(deciphered_text_bin)]))
