n1 = 60
m1 = 171.5
n2 = 50
m2 = 173.8
sd = 6.2

z = abs((m1 - m2)/sqrt(sd^2/n1 + sd^2/n2))
z
Zalpha = abs(qnorm(0.01, lower.tail=FALSE))
Zalpha

print('H0: No difference in heights')
print('H1: Juniors shorter than seniors')

if(z < Zalpha) {
	print("z < Zalpha")
	print('H0 is accepted')
} else {
	print("z > Zalpha")
	print('H0 is rejected')
}
