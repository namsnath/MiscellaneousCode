#include<iostream>
using namespace std;

struct node
{
    node *next;
    string data;
};

class LinkedList
{
    public:
    node *head = NULL;
    node *top = NULL;

    bool isEmpty()
    {
        if(head == NULL)
            return true;
        return false;
    }

    void print()
    {
        node *temp = new node;
        temp = head;
        while(temp != NULL)
        {
            cout << temp -> data << "\t";
            temp = temp -> next;
        }
    }

    void push(string value)
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
        top = temp;
    }

    void pop()
    {
        if(isEmpty())
            return;

        node *prev = new node;
        node *cursor = new node;
        cursor = head;

        while(cursor->next != NULL)
        {
            prev = cursor;
            cursor = cursor->next;
        }
        prev->next = NULL;
        top = prev;
        delete cursor;
    }

    void getTop()
    {
        if(isEmpty())
            cout << "List is empty" << endl;
        else
            cout << top->data << endl;
    }
};

int main()
{
    LinkedList *l = new LinkedList;

    int choice;
    string inp;

    do
    {
        cout << "Choose an operation:" << endl;
        cout << "1 - Push" << endl;
        cout << "2 - Pop" << endl;
        cout << "3 - Get Top" << endl;
        cout << "4 - Exit" << endl;
        cin >> choice;

        switch(choice)
        {
            case 1:
                    cout << "Enter String" << endl;
                    cin >> inp;
                    l->push(inp);
                    break;

            case 2:
                    l->pop();
                    break;

            case 3:
                    l->getTop();
                    break;

            case 4: break;
            default: cout << "Invalid Choice";
        }

    }while(choice > 0 && choice < 4);
}
