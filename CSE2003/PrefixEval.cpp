#include<iostream>
#include<string>
#include <cmath>
using namespace std;

int MAXSIZE = 30;
int TOP = -1;

bool isEmpty()
{
	if(TOP == -1)
		return true;
	return false;
}

bool isFull()
{
	if(TOP == MAXSIZE)
		return true;
	return false;
}

void push(float l[], float a)
{
	if(isFull())
		cout << "Stack is Full. Cannot Push.\n";
	else
		l[++TOP] = a;
}

void pop(float l[])
{
	if(isEmpty())
		cout << "Stack is Empty. Cannot Pop.\n";
	else
		TOP--;
}

float getTop(float l[])
{
	if(TOP == -1)
		return -1;
	else
		return l[TOP];
}

void print(float l[])
{
	if(isEmpty())
		cout << "Stack is Empty" << endl;
	else
		for(int i = 0; i <= TOP; i++)
			cout << l[i] << endl;

}

bool isOperand(char c)
{
	if(c >= '0' && c <= '9')
		return true;
	return false;
}

bool isOperator(char c)
{
	if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
		return true;
	return false;
}

float compute(float b, char op, float a)
{
	switch(op)
	{
		case '+':	return a + b; break;
		case '-':	return a - b; break;
		case '*':	return a * b; break;
		case '/':	return a / b; break;
		case '^':	return pow(a, b); break;
		default: return -1;
	}
}

string  rev(string a)
{
	int i;
	string b;
	for(i = a.size(); i >= 0; i--)
		b += a[i];

	return b;
}

int main()
{
	float Stack[MAXSIZE];

	string inp, op = "";

	cout << "Enter String:\n";
	cin >> inp;

	inp = rev(inp);

	char a;

	for(int i = 0; i < inp.size(); i++)
	{

		a = inp[i];
		if(isOperand(a))
			push(Stack, (float)(a - '0'));
		else if(isOperator(a))
		{
			float y = getTop(Stack);
			pop(Stack);
			float x = getTop(Stack);
			pop(Stack);
			float ans = compute(x, a, y);
			push(Stack, ans);
		}
	}
	if(TOP != 0)
		cout << "Invalid Expression";
	else
		cout << getTop(Stack);
}
