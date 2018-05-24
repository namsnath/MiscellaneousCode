#include<iostream>
#include<string>
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

void push(char l[], char a)
{
	if(isFull())
		cout << "Stack is Full. Cannot Push.\n";
	else
		l[++TOP] = a;
}

void pop(char l[])
{
	if(isEmpty())
		cout << "Stack is Empty. Cannot Pop.\n";
	else
		TOP--;
}

char getTop(char l[])
{
	if(TOP == -1)
		return '\0';
	else
		return l[TOP];
}

void print(char l[])
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
	if(c >= 'a' && c <= 'z')
		return true;
	if(c >= 'A' && c <= 'Z')
		return true;
	return false;
}

bool isOperator(char c)
{
	if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
		return true;
	return false;
}


bool TakesPrecedence(char OperatorA, char OperatorB)
{
	if (OperatorA == '(')
		return false;
	else if (OperatorB == '(')
		return false;
	else if (OperatorB == ')')
	   return true;
	else if ((OperatorA == '^') && (OperatorB == '^'))
		return false;
	else if (OperatorA == '^')
		return true;
	else if (OperatorB == '^')
		return false;
	else if ((OperatorA == '*') || (OperatorA == '/'))
		return true;
	else if ((OperatorB == '*') || (OperatorB == '/'))
		return false;
	else
		return true;

   }

string  rev(string a)
{
	int i, j;
	string b;
	for(i = a.size(), j = 0; i >= 0; i--, j++)
		b += a[i];

	for(i = 0; i < b.size(); i++)
	{
		if(b[i] == '(')
			b[i] = ')';
		else if(b[i] == ')')
			b[i] = '(';
	}

	return b;
}

int main()
{
	char Stack[MAXSIZE]; //List array

	string inp, op = "";

	cout << "Enter String:\n";
	cin >> inp;

	char a, top;

	inp = rev(inp);

	for(int i = 0; i < inp.size(); i++)
	{
		a = inp[i];

		if(isOperand(a))
			op += a;
		else
		{
			while(!isEmpty() && TakesPrecedence(getTop(Stack), a))
			{
				top = getTop(Stack);
				pop(Stack);
				op += top;
			}
			if(!isEmpty() && a == ')')
				pop(Stack);
			else
				push(Stack, a);
		}
	}


	while(!isEmpty())
	{
		top = getTop(Stack);
		pop(Stack);
		op += top;
	}


	op = rev(op);
	cout << op;
}
