// Write a parallel code to generate prime numbers between 1 to N using openMP
// Might need -lstdc++ as argument to compile

#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#include <iostream>

using namespace std;

int checkPrime(int n) {
	if(n <= 1) return 0;
	if(n == 2) return 1;
	if(n % 2 == 0) return 0;
	for(int i = 3; i*i < n / 2; i += 2)
		if(n % i == 0)
			return 0;
	return 1;		
}

void primeGen(int N, int threads) {
	omp_set_dynamic(0);
	printf("Primes: \n");

	#pragma omp parallel num_threads(threads)
	{
		int count = 0;
		#pragma omp for
		for(int i = 0; i < N; i++) {
			if(checkPrime(i)) count++;
		}
		printf("Count = %d\n", count);
	}
}

void doSieve(bool *sieve, int N, int threads) {
	omp_set_dynamic(0);
	printf("Sieve: \n");
	int sum = 0, count = 0;
	#pragma omp parallel for reduction(+ : sum) num_threads(threads)
		for(int i = 2; i < N; i++) {
			if(sieve[i]) {
				sum++;
				for (int j = i*2; j < N; j += i)
					sieve[j] = false;
			}
		}

	for(int i = 2; i < N; i++)
		if(sieve[i]) count++;

	printf("Count = %d\n", sum);
	printf("Actual Count = %d\n", count);
}

int main() {
	int threads, N;
	double dtime;
	bool *sieve;

	N = 10000000;

	sieve = (bool *)malloc(sizeof(bool) * N);

	for(int i = 0; i < N; i++)
		sieve[i] = true;

	sieve[0] = false;
	sieve[1] = false;

	threads = 8;
	dtime = omp_get_wtime();
	doSieve(sieve, N, threads);
	dtime = omp_get_wtime() - dtime;
	cout << "Threads = " << threads << endl;
	cout << "N = " << N << endl;
	cout << "Time Taken = " << dtime<< endl;	

	// threads = 8;
	// dtime = omp_get_wtime();
	// primeGen(N, threads);
	// dtime = omp_get_wtime() - dtime;
	// cout << "Threads = " << threads << endl;
	// cout << "N = " << N << endl;
	// cout << "Time Taken = " << dtime<< endl;

	// threads = 2;
	// dtime = omp_get_wtime();
	// primeGen(N, threads);
	// dtime = omp_get_wtime() - dtime;
	// cout << "Threads = " << threads << endl;
	// cout << "N = " << N << endl;
	// cout << "Time Taken = " << dtime<< endl;

	// threads = 1;
	// dtime = omp_get_wtime();
	// primeGen(N, threads);
	// dtime = omp_get_wtime() - dtime;
	// cout << "Threads = " << threads << endl;
	// cout << "N = " << N << endl;
	// cout << "Time Taken = " << dtime<< endl;
}