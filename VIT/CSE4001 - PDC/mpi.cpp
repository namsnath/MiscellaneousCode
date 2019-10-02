#include <iostream>
#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#define MASTER 0

// Compile: mpicc <filename> -> c, mpic++ <filename> -> cpp
// Exec: mpiexec -np 3 ./a.out OR mpirun

using namespace std;

int main(int argc, char* argv[]) {
	int numtasks, taskid, len;
	char hostname[MPI_MAX_PROCESSOR_NAME];
	
	MPI_Init(&argc, &argv);
	MPI_Comm_size(MPI_COMM_WORLD, &numtasks);
	MPI_Comm_rank(MPI_COMM_WORLD, &taskid);
	MPI_Get_processor_name(hostname, &len);
	
	cout << "Hello from task " << taskid << " on " << hostname << endl;
	if(taskid == MASTER)
		cout << "MASTER: Number of MPI Tasks is: " << numtasks << endl;
	MPI_Finalize();
}
