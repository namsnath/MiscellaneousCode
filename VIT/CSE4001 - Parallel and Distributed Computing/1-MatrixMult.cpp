// Write a parallel program to implement matrix multiplication using openMP

#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#include <iostream>

using namespace std;

void mult(double *A, double *B, double *C, int n, int threads) {
	omp_set_dynamic(0);

	#pragma omp parallel num_threads(threads)
	{
		#pragma omp for
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				double dot = 0;
				for (int k = 0; k < n; k++) {
					dot += A[i * n + k] * B[k * n + j];
				}

				C[i * n + j] = dot;
			}
		}
	}
}

int main() {
	int i, n, threads;
	double *A, *B, *C, dtime;

	n = 512;
	A = (double *)malloc(sizeof(double) * n * n);
	B = (double *)malloc(sizeof(double) * n * n);
	C = (double *)malloc(sizeof(double) * n * n);

	for (i = 0; i < n * n; i++)
	{
		A[i] = 1.0*rand() / RAND_MAX;
		B[i] = 1.0*rand() / RAND_MAX;
	}

	threads = 4;
	dtime = omp_get_wtime();
	mult(A, B, C, n, threads);
	dtime = omp_get_wtime() - dtime;
	cout << "Threads = " << threads << endl;
	cout << "Time Taken = " << dtime << "s" << endl;
	cout << "n = " << n << endl;

	threads = 2;
	dtime = omp_get_wtime();
	mult(A, B, C, n, threads);
	dtime = omp_get_wtime() - dtime;
	cout << "Threads = " << threads << endl;
	cout << "Time Taken = " << dtime << "s" << endl;
	cout << "n = " << n << endl;

	threads = 1;
	dtime = omp_get_wtime();
	mult(A, B, C, n, threads);
	dtime = omp_get_wtime() - dtime;
	cout << "Threads = " << threads << endl;
	cout << "Time Taken = " << dtime << "s" << endl;
	cout << "n = " << n << endl;
}