#include<iostream>
using namespace std;

int MAXSIZE = 10;
int CURRENTSIZE = 0;

bool isEmpty()
{
    if(CURRENTSIZE == 0)
        return true;
    return false;
}

bool isFull()
{
    if(CURRENTSIZE == MAXSIZE)
        return true;
    return false;
}

void insertAtEnd(string l[])
{
    if(isFull())
        cout << "List is full. Cannot insert.\n";
    else
    {
        string a;
        cout << "Enter a string: ";
        cin >> a;

        l[CURRENTSIZE] = a;
        CURRENTSIZE ++;
    }
}

void insertAtStart(string l[])
{
    if(isFull())
        cout << "List is full. Cannot insert.\n";
    else
    {
        string a;
        cout << "Enter a string";
        cin >> a;

        int i;

        for(i = CURRENTSIZE - 1; i >= 0; i--)
            l[i + 1] = l[i];

        l[0] = a;
        CURRENTSIZE++;
    }
}

void insertAtN(string l[])
{
    if(isFull())
        cout << "List is full. Cannot Insert.\n";
    else
    {
        int n;
        cout << "Enter the index to insert at (Indices starting from 0)";
        cin >> n;

        string a;
        cout << "Enter a string";
        cin >> a;

        int i;
        for(i = CURRENTSIZE - 1; i >= n; i--)
            l[i + 1] = l[i];
        l[n] = a;
        CURRENTSIZE++;
    }
}

void deleteFromN(string l[])
{
    if(isEmpty())
        cout << "List is Empty. Cannot Delete.\n"
    else
    {
        int n;
        cout << "Enter the index to insert at (Indices starting from 0)";
        cin >> n;

        int i;
        for(i = n; i < CURRENTSIZE; i++)
            l[i] = l[i + 1];

        CURRENTSIZE--;
        l[CURRENTSIZE] = "";
    }
}

void deleteFromEnd(string l[])
{
    if(isEmpty())
        cout << "List is Empty. Cannot Delete.\n"
    else
    {
        cout << l[CURRENTSIZE - 1];
        l[CURRENTSIZE - 1] = "";
        CURRENTSIZE--;
    }
}

void deleteFromStart(string l[])
{
    if(isEmpty())
        cout << "List is Empty. Cannot Delete.\n"
    else
    {
        cout << l[0];
        int i;
        for(i = 0; i < CURRENTSIZE; i++)
            l[i] = l[i + 1];
        CURRENTSIZE--;
        l[CURRENTSIZE] = "";
    }
}

void printList(string l[])
{
    if(isEmpty())
    {
        cout << "List is Empty.\n";
        return;
    }


    cout << "\n\nThe List is: \n";
    for(int i = 0; i < CURRENTSIZE; i++)
        cout << l[i] << "\n";
}

int searchList(string l[])
{
    string key;
    cout << "Enter string to search";
    cin >> key;

    for(int i = 0; i < CURRENTSIZE; i++)
        if(l[i] == key)
            return i;
    return -1;
}

int main()
{
    string List[MAXSIZE]; //List array

    int choice;

    do
    {
        cout << "\n\n1 - IsEmpty\n";
        cout << "2 - IsFull\n";
        cout << "3 - Insert At End\n";
        cout << "4 - Delete From End\n";
        cout << "5 - Search\n";
        cout << "6 - Print\n\n";

        cin >> choice;
        switch(choice)
        {
            case 1:
                cout << isEmpty() << endl << endl;
                break;

            case 2:
                cout << isFull() << endl << endl;
                break;

            case 3: insertAtEnd(List);
                    break;

            case 4: deleteFromEnd(List);
            break;

            case 5: searchList(List);
            break;

            case 6: printList(List);
            break;

            default: cout << "Enter a valid choice.\n\n";
        }
    }
    while(choice > 0 && choice < 7);

}
