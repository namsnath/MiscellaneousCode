#include<iostream>
using namespace std;

struct node
{
    string data;
    node *next;
};

node *head = NULL;

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
		cout << "List is Empty" << endl;
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

void insertAtStart(string data)
{
    node *temp = new node;
    temp->data = data;
    temp->next = head;
    head = temp;
}

void insertAtEnd(string value)
{
    node *temp = new node;
    temp->data = value;
    temp->next = NULL;

    if(isEmpty())
    {
        head = temp;
        return;
    }

    node *cursor = new node;
    cursor = head;

    while(cursor->next != NULL)
        cursor = cursor->next;

    cursor->next = temp;
}

void insertAtPos(int pos, string value)
{
    if(pos == 1)
    {
        insertAtStart(value);
        return;
    }

    node *temp = new node;
    temp->data = value;
    temp->next = NULL;

    if(isEmpty())
    {
        head = temp;
        return;
    }

    node *prev = new node;
    node *cursor = new node;
    cursor = head;

    for(int i = 1; i < pos; i++)
    {
        prev = cursor;
        cursor = cursor->next;
    }

    temp->next = cursor;
    prev->next = temp;
}

void deleteFromStart()
{
    node *temp = new node;
    temp = head;
    head = head->next;
    delete temp;
}

void deleteFromEnd()
{
    if(isEmpty())
        return;

    node *prev = new node;
    node *cursor = new node;
    cursor = head;
    prev = cursor;

    while(cursor->next != NULL)
    {
        prev = cursor;
        cursor = cursor->next;
    }
    prev->next = NULL;
    delete cursor;
}

void deleteFromPos(int pos)
{
    if(isEmpty())
    	return;
	node *cursor = new node;
    node *prev = new node;
    node *temp = new node;
    cursor = head;
    prev = cursor;

    for(int i = 1; i < pos; i++)
    {

        prev = cursor;
        cursor = cursor->next;
    }
    temp = prev->next;
    prev->next = cursor->next;
    delete temp;
}

int main()
{

    int choice, pos;
    string a;
    do
    {
        cout << "\nSelect An Option:" << endl;
        cout << "1 - Is Empty" << endl;
        cout << "2 - Insert At Start" << endl;
        cout << "3 - Delete From Start" << endl;
        cout << "4 - Print" << endl;
        cout << "5 - Insert At End" << endl;
        cout << "6 - Delete From End" << endl;
        cout << "7 - Insert At N" << endl;
        cout << "8 - Delete From N" << endl;

        cin >> choice;

        switch(choice)
        {
            case 1: cout << isEmpty(); break;

            case 2: cout << "Enter String" << endl;
                    cin >> a;
                    insertAtStart(a);
                    break;

            case 3: deleteFromStart(); break;

            case 4: print(); break;

            case 5: cout << "Enter String" << endl;
                    cin >> a;
                    insertAtEnd(a);
                    break;

            case 6: deleteFromEnd(); break;

            case 7: cout << "Enter position" << endl;
                    cin >> pos;
                    cout << "Enter String" << endl;
                    cin >> a;
                    insertAtPos(pos, a);
                    break;

            case 8: cout << "Enter position" << endl;
                    cin >> pos;
                    deleteFromPos(pos);
                    break;

            default: cout << "Invalid Choice" << endl;
        }
    }while(choice > 0 && choice < 9);
}
