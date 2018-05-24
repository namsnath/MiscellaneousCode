// C++ program to find number of bins required using the Best fit algorithm.

#include<iostream>
using namespace std;

// Returns number of bins required using best fit
int bestFit(int weight[], int n, int c)
{
    // Initialize result (Count of bins)
    int result = 0;

    // Create an array to store remaining space in bins, there can be at most 'n' bins
    int bin_rem[n];

    // Place items one by one
    for (int i = 0; i < n; i++)
    {
        // Find the best bin that can accomodate weight[i]
        int j;

        // Initialize minimum space left and index of best bin
        int min = c + 1, best_index = 0;

        for (j = 0; j < result; j++)
        {
            if (bin_rem[j] >= weight[i] && bin_rem[j] - weight[i] < min)
            {
                best_index = j;
                min = bin_rem[j] - weight[i];
            }
        }

        // If no bin could accommodate weight[i], create a new bin
        if (min == c + 1)
        {
            bin_rem[result] = c - weight[i];
            result++;
            best_index = result - 1;
        }
        else // Assign the item to best bin
            bin_rem[best_index] -= weight[i];

        cout << "Item " << i + 1 << " (weight " << weight[i] <<") placed in bin " << best_index << endl;
    }
    return result;
}

// Driver program
int main()
{
	int n;
	cout << "Enter number of elements n:" << endl;
	cin >> n;

	int c;
	cout << "Enter capacity of bins c: " << endl;
	cin >> c;


	int weight[n];


	cout << "Enter elements: " << endl;
	for(int i = 0; i < n; i++)
		cin >> weight[i];
	//n = 7;
    //int weight[] = {2, 5, 4, 7, 1, 3, 8};
    //int c = 10;

    int res = bestFit(weight, n, c);
    cout << "\n\nNumber of Bins required in Best Fit: " << res;
    return 0;
}
