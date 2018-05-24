#include <iostream>
#include <ctime>
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
            
        //cout << "Item " << i + 1 << " (weight " << weight[i] <<") placed in bin " << best_index << endl;   
    }
    return result;
}

// Returns number of bins required using first fit
int firstFit(int weight[], int n, int bin_cap)
{
	// Initialize result (Count of bins)
	int result = 0;

	// Create an array to store remaining space in bins, there can be at most 'n' bins
	int *bin_rem = new int[n];

	// Find the first bin that can accomodate weight[i]
	int j;

	for (int i = 0; i < n; i++)
	{
		for (j = 0; j < result; j++)
		{
			if (bin_rem[j] >= weight[i])
			{
				bin_rem[j] -= weight[i];
				break;
			}
		}

		// If no bin could accommodate weight[i], create a new bin
		if (j == result)
		{
			bin_rem[result] = bin_cap - weight[i];
			result++;
		}

	}

	return result;
}

// Returns number of bins required using next fit
int nextFit(int weight[], int n, int bin_cap)
{
	// Initialize result (Count of bins)
	int result = 0;

	//Space remaining in the bin
	int bin_rem = bin_cap;


	for (int i = 0; i < n; i++)
	{

		if (weight[i] > bin_rem)
		{
			result++;
			bin_rem = bin_cap - weight[i];
		}
		else
			bin_rem -= weight[i];
	}

	return result;
}


int main()
{
	int op, n, bin_cap, result;
	clock_t time1, time2;	//For clock times
	float time_taken;	//Run time

REP:
	cout << "\nEnter the number of items to consider : " << endl;
	cin >> n;

	cout << "\nEnter the maximum capacity of bins being used : " << endl;
	cin >> bin_cap;

	int *weight = new int[n];
	int *weightdesc = new int[n];
	int x;

	cout << "\nEnter " << n << " values : " << endl;
	for (int i = 0; i < n; i++)
	{
		cin >> x;
		weight[i] = x;
		weightdesc[i] = x;
	}

	int i, j;
	
	//Sorts weightdesc in descending order for use during Running Time Comparison
	for(i = 1 ; i < n; i++)
	{
		int key = weightdesc[i];
		j = i - 1;
		
		while (j >= 0 && weightdesc[j] < key)
			{
				weightdesc[j + 1] = weightdesc[j];
				j--;
			}
		weightdesc[j + 1] = key;
	}


	do
	{
		cout << "\nWhat would you like to do?\n1. New input\n2. First Fit\n3. Best Fit\n4. Next Fit\n5. Compare Running Time\n6. Exit\nEnter an option : " << endl;
		cin >> op;

		switch (op)
		{
		case 1:
			goto REP;
			break;

		case 2:
			time1 = clock();
			result = firstFit(weight, n, bin_cap);
			time2 = clock();
			time_taken = float(time2 - time1) / CLOCKS_PER_SEC * 1000;
			//cout << "\nThe time taken is " << float(time2 - time1) / CLOCKS_PER_SEC * 1000 << " milliseconds" << endl;
			
			cout << "\nThe number of bins required by the First Fit algorithm is : " << result;
			cout << "\nThe time taken is " << time_taken << " milliseconds" << endl;
			break;

		case 3:
			time1 = clock();
			result = bestFit(weight, n, bin_cap);
			time2 = clock();
			time_taken = float(time2 - time1) / CLOCKS_PER_SEC * 1000;

			cout << "\nThe number of bins required by the Best Fit algorithm is : " << result;
			cout << "\nThe time taken is " << time_taken << " milliseconds" << endl;
			break;

		case 4:
			time1 = clock();
			result = nextFit(weight, n, bin_cap);
			time2 = clock();
			time_taken = float(time2 - time1) / CLOCKS_PER_SEC * 1000;

			cout << "\nThe number of bins required by the Next Fit algorithm is : " << result;
			cout << "\nThe time taken is " << time_taken << " milliseconds" << endl;
			break;

		case 5:

			time1 = clock();
			result = firstFit(weight, n, bin_cap);
			time2 = clock();
			time_taken = float(time2 - time1) / CLOCKS_PER_SEC * 1000;
			cout << "\nFirst Fit: " << endl;
			cout << "Bins = " << result << endl;
			cout << "Time = " << time_taken << " milliseconds" << endl;

			time1 = clock();
			result = firstFit(weightdesc, n, bin_cap);
			time2 = clock();
			time_taken = float(time2 - time1) / CLOCKS_PER_SEC * 1000;
			cout << "\nFirst Fit Decreasing: " << endl;
			cout << "Bins = " << result << endl;
			cout << "Time = " << time_taken << " milliseconds" << endl;

			time1 = clock();
			result = nextFit(weight, n, bin_cap);
			time2 = clock();
			time_taken = float(time2 - time1) / CLOCKS_PER_SEC * 1000;
			cout << "\nNext Fit: " << endl;
			cout << "Bins = " << result << endl;
			cout << "Time = " << time_taken << " milliseconds" << endl;

			time1 = clock();
			result = firstFit(weightdesc, n, bin_cap);
			time2 = clock();
			time_taken = float(time2 - time1) / CLOCKS_PER_SEC * 1000;
			cout << "\nNext Fit Decreasing: " << endl;
			cout << "Bins = " << result << endl;
			cout << "Time = " << time_taken << " milliseconds" << endl;

			time1 = clock();
			result = bestFit(weight, n, bin_cap);
			time2 = clock();
			time_taken = float(time2 - time1) / CLOCKS_PER_SEC * 1000;
			cout << "\nBest Fit: " << endl;
			cout << "Bins = " << result << endl;
			cout << "Time = " << time_taken << " milliseconds" << endl;

			time1 = clock();
			result = bestFit(weightdesc, n, bin_cap);
			time2 = clock();
			time_taken = float(time2 - time1) / CLOCKS_PER_SEC * 1000;
			cout << "\nBest Fit Decreasing: " << endl;
			cout << "Bins = " << result << endl;
			cout << "Time = " << time_taken << " milliseconds" << endl;
			break;

		case 6:
			return 0;

		default:
			cout << "Enter a valid input";
		}

	} while (true);

    return 0;
}
