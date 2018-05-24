#include<iostream>
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

void push(string l[])
{
	if(isFull())
		cout << "Stack is Full. Cannot Push.\n";
	else
	{
		cout << "Enter a string\n";
		string a;
		cin >> a;

		l[++TOP] = a;
	}
}

void pop(string l[])
{
	if(isEmpty())
		cout << "Stack is Empty. Cannot Pop.\n";
	else
		TOP--;
}

string top(string l[])
{
	if(top == -1)
		return "";
	else
		return l[top];
}

void print(string l[])
{
	if(isEmpty())
		cout << "Stack is Empty" << endl;
	else
		for(int i = 0; i <= TOP; i++)
			cout << l[i] << endl;

}

int main()
{
	string List[MAXSIZE]; //List array

	    int choice;

	    do
	    {
	        cout << "\n\n1 - IsEmpty\n";
	        cout << "2 - IsFull\n";
	        cout << "3 - Push\n";
	        cout << "4 - Pop";
	        cout << "5 - Print\n";
	        cout << "6 - Exit\n\n";

	        cin >> choice;
	        switch(choice)
	        {
	            case 1:
	                cout << isEmpty() << endl << endl;
	                break;

	            case 2:
	                cout << isFull() << endl << endl;
	                break;

	            case 3: push(List);
	                    break;

	            case 4: pop(List);
	            		break;

	            case 5: print(List); break;

	            case 6: return 0;

	            default: cout << "Enter a valid choice.\n\n";
	        }
	    }
	    while(choice > 0 && choice < 7);

}
