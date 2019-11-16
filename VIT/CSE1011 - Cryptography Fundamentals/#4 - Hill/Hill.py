import re
alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

def adjoint(A, n):
	D = 0;
	
	if n == 1:
		return A[0][0]
		
	temp = [];
	for i in range(n):
	temp.append([]);
	
	

def m_mul(a, b):
	c = []
	for i in range(len(a)):
		c.append([])
		for j in range(len(a[i])):
			for k in range(len(b)):
				c[i][j] += a[i][k] * b[j]
	return c

print("Enter value of n, to make nxn key matrix: ")
n = int(input())
key = []



print("Enter key matrix row-wise: ")
for i in range(n):
	key.append([])
	for j in range(n):
		key[i].append(int(input()))
		
print(key)

print("Enter Plaintext:")
pt = input().upper()

if(len(pt) % n != 0):
	for i in range(n - (len(pt) % n)):
		pt += "Z"

print(pt)

chunks = re.findall(".{%s}?" % (n), pt)
print(chunks)

