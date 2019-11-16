mean = 25
sd = 5
x = c(24, 20, 30, 20, 20, 18)
n = 6

t.test(x, mu=mean, alt='less')

qt(1-0.01, 5)