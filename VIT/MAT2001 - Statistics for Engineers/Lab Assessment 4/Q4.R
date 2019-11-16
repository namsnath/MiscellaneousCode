pm = 100
psd = 15
sm = 140
n = 30

z = abs((sm-pm)*sqrt(n)/psd)
z
Zalpha = abs(qnorm(0.05/2, lower.tail=FALSE))
Zalpha

print('H0: Corn starch had no effect')
print('H1: Corn starch had effect')

if(z < Zalpha) {
	print("z < Zalpha")
	print('H0 is accepted')
} else {
	print("z > Zalpha")
	print('H0 is rejected')
}
