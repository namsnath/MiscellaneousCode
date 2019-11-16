#include <iostream>
#include <vector>
#include <string>
#include <ctype.h>
#include <stdlib.h>

using namespace std;

static char** create2DArray(int rowCount, int colCount) {
    char** arr = new char*[rowCount];
    for(int i = 0; i < rowCount; i++)
        arr[i] = new char[colCount];
    return arr;
}

/*static string toUpper(string str) {
    string output = str;
    int strLen = str.size();

    for(int i = 0; i < strLen; i++)
        output[i] = toUpper(output[i]);

    return output;
}*/

static vector<int> findAllOccurences(string str, char value) {
    vector<int> indexes;

    int index = 0;
    while((index = str.find(value, index)) != -1)
        indexes.push_back(index++);

    return indexes;
}

static string removeAllDuplicates(string str, vector<int> indexes) {
    string retVal = str;
    for(int i = indexes.size() - 1; i >= 1; i--)
        retVal = retVal.erase(indexes[i], 1);
    return retVal;
}

/*
static int mod(int a, int b) {
    return ()
}
*/

static string removeChar(string str, char ch) {
    string output = str;

    for(int i = 0; i < output.size(); i++)
        if(output[i] == ch)
            output = output.erase(i, 1);

    return output;
}

static char** generateKeySquare(string key) {
    char** keySquare = create2DArray(5, 5);
    string defaultKeySquare = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
    string tempKey = key.empty() ? "CIPHER" : key;

    tempKey = removeChar(tempKey, 'J');
    tempKey += defaultKeySquare;

    for(int i = 0; i < 25; i++) {
        vector<int> indexes = findAllOccurences(tempKey, defaultKeySquare[i]);
        tempKey = removeAllDuplicates(tempKey, indexes);
    }

    tempKey = tempKey.substr(0, 25);
    for(int i = 0; i < 25; i++)
        keySquare[i / 5][i % 5] = tempKey[i];

    return keySquare;
}

int main() {
    char** s = generateKeySquare("");
    for(int i = 0 ; i < 5; i++) {
        for(int j = 0; j < 5; j++) {
            cout << s[i][j];
        }
        cout << "\n";
    }
}

