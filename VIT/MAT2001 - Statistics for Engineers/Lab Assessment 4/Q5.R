pm = 1800
psd = 100
sm = 1850
n = 50

z = abs((sm - pm)*sqrt(n)/psd)
z
Zalpha = abs(qnorm(0.01, lower.tail=FALSE))
Zalpha

print('H0: No change in strength')
print('H1: Strength Increased')

if(z < Zalpha) {
	print("z < Zalpha")
	print('H0 is accepted')
} else {
	print("z > Zalpha")
	print('H0 is rejected')
}
