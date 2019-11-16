// Write a parallel code to generate prime numbers between 1 to N using openMP
// Might need -lstdc++ as argument to compile

#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#include <iostream>

using namespace std;

void doSieve(bool *sieve, int M, int N, int threads) {
	omp_set_dynamic(0);
	int sum = 0, count = 0;
	#pragma omp parallel for reduction(+ : sum) num_threads(threads)
		for(int i = 2; i < N; i++) {
			if(sieve[i]) {
				sum++;
				for (int j = i*2; j < N; j += i)
					sieve[j] = false;
			}
		}

	for(int i = M; i < N; i++)
		if(sieve[i]) count++;

	printf("Prime Count = %d\n", count);
}

int main() {
	int threads, N, M;
	double dtime;
	bool *sieve;

	cout << "Enter M: ";
	cin >> M;

	cout << "Enter N: ";
	cin >> N;

	sieve = (bool *)malloc(sizeof(bool) * N);

	for(int i = 0; i < N; i++)
		sieve[i] = true;

	sieve[0] = false;
	sieve[1] = false;

	cout << endl;
	threads = 8;
	dtime = omp_get_wtime();
	doSieve(sieve, M, N, threads);
	dtime = omp_get_wtime() - dtime;
	cout << "Threads = " << threads << endl;
	cout << "Time Taken = " << dtime<< endl;	
}