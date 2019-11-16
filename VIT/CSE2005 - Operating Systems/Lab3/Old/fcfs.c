#include<stdio.h>
#include<string.h>

void findWaitingTime(int processes[], int n, int bt[], int wt[]) {
	wt[0] = 0;
	int i;	
	for(i = 1; i < n; i++)
		wt[i] = bt[i-1] + wt[i - 1];
}

void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) {
	int i;
	for(i = 0; i < n; i++)
		tat[i] = bt[i] + wt[i];
}

void findAvgTime(int processes[], int n, int bt[]) {
	int wt[n], tat[n], total_wt = 0, total_tat = 0, i;
	findWaitingTime(processes, n, bt, wt);
	findTurnAroundTime(processes, n, bt, wt, tat);
	printf("Processes  Burst Time  Waiting Time  Turn Around Time\n");

	for(i = 0; i < n; i++) {
		total_wt += wt[i];
		total_tat += tat[i];
		printf("  %d\t\t%d\t%d\t\t%d\n", (i + 1), bt[i], wt[i], tat[i]);
	}

	printf("Average Waiting Time = %f\n", ((float)total_wt/(float)n));
	printf("Average TurnAround Time = %f\n", ((float)total_tat/(float)n));
}

int main() {
	int processes[] = {1, 2, 3};
	int n = sizeof(processes) / sizeof(processes[0]);
	int bt[] = {10, 5, 8};

	findAvgTime(processes, n, bt);
	return 0;
	
}

