P = 20/100
Q = 1 - P
x = 50
n = 400
p = x/n

z = abs((p - P)/sqrt(P * Q / n))
z
Zalpha = abs(qnorm(0.05/2, lower.tail=FALSE))
Zalpha

print('H0: Production of day is representative')
print('H1: Production of day is not representative')

if(z < Zalpha) {
	print("z < Zalpha")
	print('H0 is accepted')
} else {
	print("z > Zalpha")
	print('H0 is rejected')
}