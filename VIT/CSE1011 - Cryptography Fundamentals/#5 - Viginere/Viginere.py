a = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
table = []
key_m = []
key = ""
pt = ""
ct = ""

print("Enter key: ")
key = input().upper()

print("Enter plaintext:")
pt = input().upper()

#key = 'NOW'
#pt = 'TOBEORNOTTOBE'

def generateTable():
	for i in range(len(a)):
		table.append([])
		for j in range(len(a)):
			table[i].append(a[(i + j) % 26])
	for i in range(len(a)):
		print("".join(table[i]))
			
def makeKey(key):
	print(key)
	key_m = []
	for i in range(len(pt)):
		key_m.append(key[i % len(key)])
	key = "".join(key_m)
	return key

#pt = list(pt)
generateTable()
key = makeKey(key)

#key = "".join(key_m)
#pt = "".join(pt)
	
print("PlainText: ", pt)	
print("Key: ", key)


ct = ""
for i in range(len(key_m)):
	ct += table[a.index(key_m[i])][a.index(pt[i])]
print("Cipher Text: ", ct)

pt_new = ""
for i in range(len(key_m)):
	row = a.index(key[i])
	col = table[row].index(ct[i])
	pt_new += a[col]
print("Deciphered Text: ", pt_new)