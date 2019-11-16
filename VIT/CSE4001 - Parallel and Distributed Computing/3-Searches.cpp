// Write a parallel program to implement matrix multiplication using openMP

// #pragma omp declare reduction (reduction-identifier : typename-list : combiner) [initializer-clause]
// reduction-identifier		Is either an identifier or one of the following operators: +, -, *, &, |, ^, && and ||
//  typename-list			Is a list of type names.
//  combiner				Is an expression that specifies how partial results can be combined into a single value.

// The combiner can use the special variable identifiers omp_in and omp_out that are of the type of the variables being reduced with this reduction-identifier. These are the only variables allowed in the combiner.

// The omp_in identifier refers to the partial result local to each thread, while the omp_out identifier refers to the storage that holds the resulting combined value after executing the combiner.

// The number of times the combiner is executed, and the order of these executions, for any reduction clause is unspecified.

#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <omp.h>
#include<algorithm>

	using namespace std;

struct Compare
{
	int val;
	int index;
};

#pragma omp declare reduction(maximum : struct Compare : omp_out = omp_in.val > omp_out.val ? omp_in : omp_out)

void swap(double *a, double *b)
{
	double temp = *a;
	*a = *b;
	*b = temp;
}

void linearSearch(double *A, int n, double item, int threads) {
	omp_set_dynamic(0);
	double pos = -1;

	#pragma omp parallel for num_threads(threads)
		for (int i = 0; i < n; i++)
			if(A[i] == item)
				pos = i;

	cout << "Found at position = " << pos << endl;
}

void customSort(double *A, int n, int threads) {
	omp_set_dynamic(0);

	for(int i = 0; i < n; i++) {
		struct Compare max;
		max.val = A[i];
		max.index = i;

		#pragma omp parallel for num_threads(threads) reduction(maximum:max)
		for (int j = 0 + 1; j < n; j++) {
			if (A[j] > max.val) {
				max.val = A[j];
				max.index = j;
			}
		}

		swap(&A[i], &A[max.index]);
	}
}

void notWorkingBinarySearch(double *A, int start, int end, double item, int N) {
	int searchIndex = (end - start) / 2;
	int low = start - 1;
	int high = end + 1;
	int found = 0;

	while(low <= high) {
		if(A[searchIndex] == item) {
			cout << "Found at " << searchIndex << endl;
			found = 1;
			return;
		} else if(A[searchIndex] < item) {
			low = searchIndex + 1;
		} else if(A[searchIndex] > item) {
			high = searchIndex - 1;
		}
		searchIndex = (high - low) / 2;
	}

	s
}

void binarySearch(double *A, int n, double item, int threads) {
	int first = 0;
	int last = n - 1;
	int middle = (first + last) / 2;

	#pragma omp parallel num_threads(threads) 
	while (first <= last)
	{
		if (A[middle] < item)
		{
			cout << A[middle];
			first = middle + 1;
		}
		else if (A[middle] == item)
		{
			cout << item << " found in the array at the location " << middle << "\n";
			break;
		}
		else
		{
			last = middle - 1;
		}
		middle = (first + last) / 2;
	}
	if (first > last)
	{
		cout << item << " not found in the array" << endl;
	}
}

int main()
{
	int n = 1000000;
	int i, threads;
	int count, num, first, last, middle, pos;
	double *A, dtime, val;

	A = (double *)malloc(sizeof(double) * n);
	for (i = 0; i < n; i++)
		A[i] = 1.0 * rand() / RAND_MAX;

	pos = rand() % n;	
	val = A[pos];
	threads = 4;

	cout << A[pos] << endl;
	cout << "Pos = " << pos << ", Val = " << val << endl << endl;

	cout << "Linear:" << endl;
	dtime = omp_get_wtime();
	linearSearch(A, n, A[pos], threads);
	dtime = omp_get_wtime() - dtime;
	cout << "Threads = " << threads << endl;
	cout << "Time Taken = " << dtime << "s" << endl;
	cout << "n = " << n << endl;

	int blockSize = n / threads;
	sort(A, A + sizeof(A)/sizeof(double));
	// sort(A, A + n * sizeof(double));

	cout << endl;

	cout << "Binary:" << endl;
	dtime = omp_get_wtime();
	binarySearch(A, n, A[pos], threads);
	dtime = omp_get_wtime() - dtime;
	cout << "Actual Position = " << pos << endl;
	cout << "Threads = " << threads << endl;
	cout << "Time Taken = " << dtime << "s" << endl;
	cout << "n = " << n << endl;

	// 	dtime = omp_get_wtime();
	// #pragma parallel for
	// 	for(int i = 0; i < threads; i++) 
	// 		notWorkingBinarySearch(A, i * blockSize, i * blockSize + blockSize - 1, A[pos], n);
	// dtime = omp_get_wtime() - dtime;
	// cout << "Actual Position = " << pos << endl;
	// cout << "Threads = " << threads << endl;
	// cout << "Time Taken = " << dtime << "s" << endl;
	// cout << "n = " << n << endl;
}