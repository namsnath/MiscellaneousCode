#include<iostream>
using namespace std;

char encipher(int cipher, char n){
    if(n + cipher > 122)
            n = (n + cipher) % 122 + 96;
        else
            n = (n + cipher);
    return n;
}

int main() {
    string pt;
    string et, dt;
    int cipher;

    cout << "Enter a string to encipher/decipher \n";
    cin >> pt;
    et = pt;
    dt = pt;

    cout << "Enter key\n";
    cin >> cipher;

   for(int i = 0; i < pt.length(); i++) {
        et[i] = encipher(cipher, pt[i]);
    }

    cout << "Enciphered Text: \n";
    cout << et;

    for(int i = 0 ; i < pt.length(); i++) {
        dt[i] = encipher((26 - cipher), pt[i]);
    }

    cout << "\nDeciphered Text: \n";
    cout << dt;
}
