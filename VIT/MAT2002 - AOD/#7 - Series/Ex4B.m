clc
clear
syms x a0 a1 a2 a3
a = [a0 a1 a2 a3];
y = sum(a.*(x).^(0:3));
dy = diff(y);
d2y = diff(dy);
gde = collect((1-x^2)*d2y+2*y,x);
cof=coeffs(gde,x);
A2=solve(cof(1),a2);
A3=solve(cof(2),a3);
y=subs(y,a2,A2);
y = subs(y, a3, A3);
y=coeffs(y,[a1 a0]);
disp('Solution is')
disp(['y=A(',char(y(1)),'+ ...)+B(',char(y(2)),'+ ...)'])