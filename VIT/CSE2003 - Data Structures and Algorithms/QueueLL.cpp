#include<iostream>
using namespace std;

struct node
{
    string data;
    node *next;
};

class QueueLL
{
public:
	node *head = NULL;
	node *tail = NULL;

	bool isEmpty()
	{
	    if(head == NULL)
	        return true;
	    return false;
	}

	void print()
	{
		if(isEmpty())
		{
			cout << "Queue is Empty" << endl;
			return;
		}

	    node *temp = new node;
	    temp = head;
	    while(temp != NULL)
	    {
	        cout << temp -> data << "\t";
	        temp = temp -> next;
	    }
	}

	void enqueue(string value)
	{
	    node *temp = new node;
	    temp->data = value;
	    temp->next = NULL;

	    if(isEmpty())
	    {
	        head = temp;
	        tail = temp;
	        return;
	    }

	    node *cursor = new node;
	    cursor = head;

	    while(cursor->next != NULL)
	        cursor = cursor->next;

	    cursor->next = temp;

	}


	void dequeue()
	{
	    if(isEmpty())
	    {
	    	cout << "Queue is Empty, Cannot Dequeue" << endl;
	    	return;
	    }

		node *temp = new node;
	    temp = head;
	    head = head->next;
	    delete temp;

	}
};



int main()
{

	QueueLL l;

    int choice;
    string a;
    do
    {
        cout << "\nSelect An Option:" << endl;
        cout << "1 - Is Empty" << endl;
        cout << "2 - Enqueue" << endl;
        cout << "3 - Dequeue" << endl;
        cout << "4 - Print" << endl;
        cout << "9 - Exit" << endl;

        cin >> choice;

        switch(choice)
        {
            case 1: cout << l.isEmpty(); break;

            case 2: cout << "Enter String" << endl;
                    cin >> a;
                    l.enqueue(a);
                    break;

            case 3: l.dequeue(); break;

            case 4: l.print(); break;

            case 9:	return 0;

            default: cout << "Invalid Choice" << endl;
        }
    } while(choice > 0 && choice < 5);
}
