x = c(23, 27, 28, 28, 29, 30, 31, 33, 35, 36)
y = c(18, 20, 22, 27, 21, 29, 27 ,29, 28, 29)
var(x)
var(y)
var(x, y)
r = var(x, y) / sqrt(var(x) * var(y))
r
cor(x, y)