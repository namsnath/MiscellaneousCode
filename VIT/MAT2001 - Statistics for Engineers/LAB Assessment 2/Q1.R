low = seq(30, 48, 2)
high = seq(32, 50, 2)
x = (high + low) / 2
f = c(3, 8, 24, 31, 50, 61, 38, 21, 12, 2)
data = data.frame(x, f)
mean = mean(rep(x, f))

cf = cumsum(f)
n = sum(f)
mc = min(which(cf >= n/2))
h = 2
fr = f[mc]
c = cf[mc - 1]
l = x[mc] - h/2
median = l + ((n/2 - c) / fr) * h

m = which(f == max(f))
fm = f[m]
f1 = f[m - 1]
f2 = f[m + 1]
l = x[m] - h/2
mode = l + (fm - f1)/(2*fm - f1 - f2) * h

sd = sd(rep(x, f))

q = c()
cr = c()
h = c()
l = c()
qdata = c()
for(i in c(1, 2, 3)) {
	q = c(q, min(which(cf >= i*n/4)))
	cr = c(cr, cf[q[i] - 1])
	h = c(h, high[q[i]] - low[q[i]])
	l = c(l, x[q[i]] - h[i]/2)
	qdata = c(qdata, l[i] + (h[i] / f[q[i]]) * ((i*n/4) - cr[i]))
}
qdata
qd = (qdata[3] - qdata[1]) / 2

data
mean
median
mode
sd
qd
