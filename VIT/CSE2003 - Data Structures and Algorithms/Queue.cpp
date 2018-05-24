#include<iostream>
using namespace std;

int MAXSIZE = 10;

int FRONT = -1;
int REAR = -1;

bool isEmpty()
{
	if(FRONT == -1 && REAR == -1)
		return true;
	return false;
}

bool isFull()
{
	if(REAR == MAXSIZE - 1)
		return true;
	return false;
}

void enqueue(string l[])
{
	if(isFull())
	{
		cout << "Queue is Full. Cannot Enqueue.\n";
		return;
	}
	else if(FRONT == -1 && REAR == -1)
	{
		FRONT = 0;
		REAR = 0;
	}

	cout << "ENter a String\n";
	string a;
	cin >> a;
	l[++REAR] = a;

}

void dequeue(string l[])
{
	if(isEmpty())
	{
		cout << "Queue is Empty. Cannot Dequeue.\n";
		return;
	}
	else if(FRONT == REAR)
	{
		FRONT = -1;
		REAR = -1;
	}

	FRONT++;
}

string front(string l[])
{
	if(FRONT == -1)
		return "";
	else
		return l[FRONT];
}

void print(string l[])
{
	if(FRONT == REAR)
	{
		FRONT = -1;
		REAR = -1;
	}

	if(isEmpty())
		cout << "Queue is Empty" << endl;
	else
		for(int i = FRONT; i <= REAR; i++)
			cout << l[i] << endl;

}

int main()
{
	string Queue[MAXSIZE]; //List array

	    int choice;

	    do
	    {
	        cout << "\n\n1 - IsEmpty\n";
	        cout << "2 - IsFull\n";
	        cout << "3 - Enqueue\n";
	        cout << "4 - Dequeue\n";
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

	            case 3: enqueue(Queue);
	                    break;

	            case 4: dequeue(Queue);
	            		break;

	            case 5: print(Queue); break;

	            case 6: return 0;

	            default: cout << "Enter a valid choice.\n\n";
	        }
	    }
	    while(choice > 0 && choice < 7);

}
