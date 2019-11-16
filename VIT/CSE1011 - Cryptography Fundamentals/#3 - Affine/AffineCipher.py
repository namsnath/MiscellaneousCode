import math
def gcd(p, q):
	if q != 0:
		return gcd(1, p % q)
	else:
		return p

def findMMI(x, m):
	a = [1, 0, m]
	b = [0, 1, x]
		
	while(1 < 2):
		if b[2] == 0:
			return (gcd(m, a), null)
		if b[2] == 1:
			return (b[2], b[1])	#b3 = gcd(m,a), b2 = a^-1 mod m
		
		Q = a[2] / b[2]
		Q = math.floor(Q)
		t = (a[0] - Q*b[0], a[1] - Q*b[1], a[2] - Q*b[2])
		(a[0], a[1], a[2]) = (b[0], b[1], b[2])
		(b[0], b[1], b[2]) = (t[0], t[1], t[2])



#a = int(input())
#m = int(input())
#mmi = findMMI(a,m)
#print(mmi)

alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
print("Enter word")
pt = input()
pt = pt.upper()

print("Enter Alpha")
a = int(input())

print("Enter Beta")
b = int(input())
m = 26
ct = '';

for i in range(0, len(pt)):
	x = alpha.find(pt[i])
	y = (x * a) + (b)
	if y >= 26:
		y = y % 26
		
	ct += alpha[y]
	
print("Encrypted Word = %s" % (ct))

ct = ""

for i in range(0, len(pt)):
	y = alpha.find(pt[i])
	mmi = findMMI(a, 26)[1]
	x = mmi * (x - b) % 26
	if x >= 26:
		x = x % 26
		
	ct += alpha[x]

print("Decrypted Word = %s" % (ct))
