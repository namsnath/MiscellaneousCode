// Write a parallel program to implement matrix multiplication using openMP

#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <omp.h>

using namespace std;

void sum(double *A, int n, int threads)
{
	omp_set_dynamic(0);
	double sum = 0;

	#pragma omp parallel for num_threads(threads) reduction(+ : sum)
			for(int i = 0; i < n; i++) 
				sum += A[i];

	cout << "Sum = " << sum << endl;
}

int main()
{
	int i, n, threads;
	double *A, dtime;

	// srand(time(0));

	n = 100000000;
	A = (double *)malloc(sizeof(double) * n);
	for (i = 0; i < n; i++)
		A[i] = 1.0 * rand() / RAND_MAX;

	threads = 4;
	dtime = omp_get_wtime();
	sum(A, n, threads);
	dtime = omp_get_wtime() - dtime;
	cout << "Threads = " << threads << endl;
	cout << "Time Taken = " << dtime << "s" << endl;
	cout << "n = " << n << endl;

	// threads = 2;
	// dtime = omp_get_wtime();
	// sum(A, n, threads);
	// dtime = omp_get_wtime() - dtime;
	// cout << "Threads = " << threads << endl;
	// cout << "Time Taken = " << dtime << "s" << endl;
	// cout << "n = " << n << endl;

	// threads = 1;
	// dtime = omp_get_wtime();
	// sum(A, n, threads);
	// dtime = omp_get_wtime() - dtime;
	// cout << "Threads = " << threads << endl;
	// cout << "Time Taken = " << dtime << "s" << endl;
	// cout << "n = " << n << endl;
}