#include<iostream>
#include<string>
using namespace std;

int MAXSIZE = 10;
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

int main()
{
	char List[MAXSIZE]; //List array

	string input;

	cout << "Enter String:\n";
	cin >> input;

	char a;

	for(int i = 0; i < (int)input.length(); i++)
	{
		if(input[i] == '(' || input[i] == '[' || input[i] == '{')
			push(List, input[i]);
		else
		{
			a = getTop(List);
			switch(input[i])
			{
				case ')':
					pop(List);
					if(a == '[' || a == '{')
					{
						cout << "Not Balanced";
						return 0;
					}
					break;

				case ']':
					pop(List);
					if(a == '(' || a == '{')
					{
						cout << "Not Balanced";
						return 0;
					}
					break;

				case '}':
					pop(List);
					if(a == '(' || a == '[')
					{
						cout << "Not Balanced";
						return 0;
					}
					break;
			}

		}

	}
	cout << "Balanced";

}
