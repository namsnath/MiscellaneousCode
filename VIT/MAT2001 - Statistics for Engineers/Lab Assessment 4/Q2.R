p1 = 800/1200
p2 = 800/1000
n1 = 1200
n2 = 1000

p = (n1*p1 + n2*p2)/(n1+n2)
q = 1-p

z = abs((p1-p2) / sqrt(p*q*(1/n1 + 1/n2)))
z
Zalpha = abs(qnorm(0.05, lower.tail=FALSE))
Zalpha

print('H0: No significant difference in proportion of pass')
print('H1: Proportion of pass in University significantly greater than that in college')

if(z < Zalpha) {
	print("z < Zalpha")
	print('H0 is accepted')
} else {
	print("z > Zalpha")
	print('H0 is rejected')
}
