// Write a parallel program to implement matrix multiplication using openMP

#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <omp.h>

using namespace std;

void mult(double *A, double *B, int n, int threads)
{
	omp_set_dynamic(0);
	double dot = 0;

	#pragma omp parallel num_threads(threads) reduction(+ : dot)
	{
		#pragma omp for
			for(int i = 0; i < n; i++) 
				dot += A[i] * B[i];
	}

	cout << "Dot Product = " << dot << endl;
}

int main()
{
	int i, n, threads;
	double *A, *B, dtime;

	n = 100000000;
	A = (double *)malloc(sizeof(double) * n);
	B = (double *)malloc(sizeof(double) * n);

	for (i = 0; i < n; i++)
	{
		A[i] = 1.0 * rand() / RAND_MAX;
		B[i] = 1.0 * rand() / RAND_MAX;

		// cout << A[i] << " x " << B[i] << endl;
	}

	threads = 4;
	dtime = omp_get_wtime();
	mult(A, B, n, threads);
	dtime = omp_get_wtime() - dtime;
	cout << "Threads = " << threads << endl;
	cout << "Time Taken = " << dtime << "s" << endl;
	cout << "n = " << n << endl;

	threads = 2;
	dtime = omp_get_wtime();
	mult(A, B, n, threads);
	dtime = omp_get_wtime() - dtime;
	cout << "Threads = " << threads << endl;
	cout << "Time Taken = " << dtime << "s" << endl;
	cout << "n = " << n << endl;

	threads = 1;
	dtime = omp_get_wtime();
	mult(A, B, n, threads);
	dtime = omp_get_wtime() - dtime;
	cout << "Threads = " << threads << endl;
	cout << "Time Taken = " << dtime << "s" << endl;
	cout << "n = " << n << endl;
}