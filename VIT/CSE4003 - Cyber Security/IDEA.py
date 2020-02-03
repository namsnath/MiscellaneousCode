import math

with open('IDEA_Verbose_Output.txt', 'w+') as f:

	def hexToBinaryFill(hex_str, fill=128):
		return bin(int(hex_str, 16))[2:].zfill(fill)


	def decimalToBinaryFill(decimal, fill=8):
		if decimal >= 0:  # For positive numbers
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

			print(bit_groups[i: i+4], hex_group, file=f)


	def rotate(bin_str):
		return bin_str[25:] + bin_str[: 25]


	def addModulo(bin_1, bin_2):
		value = (int(bin_1, 2) + int(bin_2, 2)) % (2**16)
		binary_value = decimalToBinaryFill(value, 16)

		print("%s + %s = %s" % (bin_1, bin_2, binary_value), file=f)
		print("%s + %s = %s" % (int(bin_1, 2), int(bin_2, 2), value), file=f)

		return binary_value


	def multModulo(bin_1, bin_2):
		if int(bin_1, 2) == 0:
			bin_1 = decimalToBinaryFill(2**16, 16)

		if int(bin_2, 2) == 0:
			bin_2 = decimalToBinaryFill(2**16, 16)

		if int(bin_1, 2) == 2**16:
			bin_1 = '0' * len(bin_1)

		if int(bin_2, 2) == 2**16:
			bin_2 = '0' * len(bin_2)

		value = (int(bin_1, 2) * int(bin_2, 2)) % (2**16 + 1)
		binary_value = decimalToBinaryFill(value, 16)

		print("%s * %s = %s" % (bin_1, bin_2, binary_value), file=f)
		print("%s * %s = %s" % (int(bin_1, 2), int(bin_2, 2), value), file=f)

		return binary_value


	def bitwiseXOR(bin_1, bin_2):
		value = int(bin_1, 2) ^ int(bin_2, 2)
		binary_value = decimalToBinaryFill(value, 16)

		print("%s XOR %s = %s" % (bin_1, bin_2, binary_value), file=f)
		print("%s XOR %s = %s" % (int(bin_1, 2), int(bin_2, 2), value), file=f)

		return binary_value


	def modInv(a):
		a = int(a, 2)
		b = int('10001', 16)  # 65537
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

		print('Rotation 1', file=f)
		print('Initial =', bin_str, file=f)
		keys128.append(bin_str)

		for i in range(6):
			print('\n\nRotation', i+2, file=f)
			print('Initial =', bin_str, file=f)
			bin_str = rotate(bin_str)
			print('Rotated =', bin_str, file=f)
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

		print("Encryption Keys:", file=f)
		print("#, Binary, Hex", file=f)
		for i in range(len(enc_keys)):
			print(i+1, enc_keys[i], binaryToHexFill(enc_keys[i]), file=f)

		print("\n\nDecryption Keys:", file=f)
		print("#, Binary, Hex", file=f)
		for i in range(len(dec_keys)):
			print(i+1, dec_keys[i], binaryToHexFill(dec_keys[i]), file=f)

		return enc_keys, dec_keys


	def ideaRound(bin_plaintext, keys):
		plaintext_blocks = [bin_plaintext[i: i+16] for i in range(0, len(bin_plaintext), 16)]
		op = []
		steps = ['' for i in range(10)]

		print("PtBl =", plaintext_blocks, file=f)
		print("Keys =", keys, file=f)

		print('\nstep1: P1 * K1', file=f)
		steps[0] = multModulo(plaintext_blocks[0], keys[0])		# P1 * K1

		print('\nstep2: P2 + K2', file=f)
		steps[1] = addModulo(plaintext_blocks[1], keys[1])		# P2 + K2

		print('\nstep3: P3 + K3', file=f)
		steps[2] = addModulo(plaintext_blocks[2], keys[2])		# P3 + K3

		print('\nstep4: P4 * K4', file=f)
		steps[3] = multModulo(plaintext_blocks[3], keys[3])  	# P4 * K4

		print('\nstep5: step1 XOR step3', file=f)
		steps[4] = bitwiseXOR(steps[0], steps[2])				# step1 XOR step3

		print('\nstep6: step2 XOR step4', file=f)
		steps[5] = bitwiseXOR(steps[1], steps[3])				# step2 XOR step4

		print('\nstep7: step5 * K5', file=f)
		steps[6] = multModulo(steps[4], keys[4])				# Step5 * K5

		print('\nstep8: step6 + step7', file=f)
		steps[7] = addModulo(steps[5], steps[6])				# step6 + step7

		print('\nstep9: step8 * K6', file=f)
		steps[8] = multModulo(steps[7], keys[5])				# step8 * K6

		print('\nstep10: step7 + step9', file=f)
		steps[9] = addModulo(steps[6], steps[8])				# step7 + step9

		print('\nC1: step1 XOR step9', file=f)
		op.append(bitwiseXOR(steps[0], steps[8]))				# Step1 XOR Step9

		print('\nC2: step3 XOR step9', file=f)
		op.append(bitwiseXOR(steps[2], steps[8]))				# Step3 XOR Step9

		print('\nC3: step2 XOR step10', file=f)
		op.append(bitwiseXOR(steps[1], steps[9]))				# Step2 XOR Step10

		print('\nC4: step4 XOR step10', file=f)
		op.append(bitwiseXOR(steps[3], steps[9]))				# Step4 XOR Step10

		output_bin = ''.join(op)
		print("\nOpRn =", output_bin, file=f)

		return output_bin


	def halfRound(bin_plaintext, keys):
		plaintext_blocks = [bin_plaintext[i: i+16] for i in range(0, len(bin_plaintext), 16)]
		op = []

		print("PtBl =", plaintext_blocks, file=f)
		print("Keys =", keys, file=f)

		print('\nstep1: P1 * K1', file=f)
		op.append(multModulo(plaintext_blocks[0], keys[0]))  	# P1 * K1

		print('\nstep2: P3 + K2', file=f)
		op.append(addModulo(plaintext_blocks[2], keys[1]))		# P3 + K2

		print('\nstep3: P2 + K3', file=f)
		op.append(addModulo(plaintext_blocks[1], keys[2]))		# P2 + K3

		print('\nstep4: P4 * K4', file=f)
		op.append(multModulo(plaintext_blocks[3], keys[3]))  	# P4 * K4

		output_bin = ''.join(op)
		print("\nOpRn =", output_bin, file=f)

		return output_bin


	hex_key = "11225577AABBCCDDEEFF3344668899AA"
	plaintext = "NEXTMOVE"
	enc_keys, dec_keys = keygen(hex_key)
	plaintext_bin = ''.join([decimalToBinaryFill(i) for i in asciiToDecimalList(plaintext)])

	print("\nPlaintext: " + plaintext, file=f)
	print("\nPlaintext Decimal:", file=f)
	print(asciiToDecimalList(plaintext), file=f)
	print("\nPlaintext Binary: " + plaintext_bin, file=f)

	print("\nKey: " + hex_key, file=f)
	print("\nKey Binary: " + hexToBinaryFill(hex_key), file=f)

	print("\n\n", file=f)

	intermediate_bin = plaintext_bin
	for i in range(8):
		print('\n\nRound', i+1, file=f)
		keyIndex = i*6
		intermediate_bin = ideaRound(
			intermediate_bin, 
			enc_keys[keyIndex:keyIndex+6]
		)

	print('\nFinal Half-Round', file=f)
	ciphertext_bin = halfRound(intermediate_bin, enc_keys[48:52])

	print("\n\nCiphertext Binary: " + ciphertext_bin, file=f)

	print("\nCiphertext Decimal", file=f)
	print(binaryToDecimalList(ciphertext_bin), file=f)

	print("\nCiphertext ASCII", file=f)
	print([chr(i) for i in binaryToDecimalList(ciphertext_bin)], file=f)

	print('\n\nSTARTING DECRYPTION', file=f)
	intermediate_bin = ciphertext_bin

	for i in range(8):
		print('\n\nRound', i+1, file=f)
		keyIndex = i*6
		roundKeys = dec_keys[keyIndex:keyIndex+6]
		intermediate_bin = ideaRound(intermediate_bin, roundKeys)

	print('\nFinal Half-Round', file=f)
	deciphered_text_bin = halfRound(intermediate_bin, dec_keys[48:52])

	print("\n\nDeciphered Binary: " + deciphered_text_bin, file=f)

	print("\nDeciphered Decimal", file=f)
	print(binaryToDecimalList(deciphered_text_bin), file=f)

	print("\nDeciphered ASCII", file=f)
	print([chr(i) for i in binaryToDecimalList(deciphered_text_bin)], file=f)

	print('\nDeciphered String:', ''.join(
		[chr(i) for i in binaryToDecimalList(deciphered_text_bin)]), file=f)
