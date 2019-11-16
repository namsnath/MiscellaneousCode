x = c(3.545, 2.6, 3.245, 3.93, 3.995, 3.115, 3.235, 3.225, 2.44, 3.24, 2.29, 2.5, 4.02)
y = c(30, 32, 30, 24, 26, 30, 33, 27, 37, 32, 37, 34, 26)
data = data.frame(x, y)
varx = var(x)
vary = var(y)
varxy = var(x, y)
cor = varxy / sqrt(varx * vary)
data
cor
plot(x, y, main="Weight vs Fuel Efficiency", xlab="Weight", ylab="Fuel Efficieny", col="red")