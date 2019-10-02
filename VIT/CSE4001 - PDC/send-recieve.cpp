#include <iostream>
#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#define MASTER 0

// Compile: mpicc <filename> -> c, mpic++ <filename> -> cpp
// Exec: mpiexec -np 3 ./a.out OR mpirun

using namespace std;

int main(int argc, char* argv[]) {
	int numtasks, taskid, len, partner, message;
	char hostname[MPI_MAX_PROCESSOR_NAME];
	
	MPI_Status status;
	
	MPI_Init(&argc, &argv);
	MPI_Comm_size(MPI_COMM_WORLD, &numtasks);
	MPI_Comm_rank(MPI_COMM_WORLD, &taskid);
	
	if(numtasks % 2 != 0)
		if(taskid == MASTER)
			cout << "Need an even number of tasks." << endl;
	else {
		if(taskid == MASTER)
			cout << "MASTER: Number of tasks = " << numtasks << endl;
			
		MPI_Get_processor_name(hostname, &len);
		cout << "Hello from task " << taskid << " on " << hostname << endl;
		
		if(taskid < numtasks/2) {
			partner = numtasks / 2 + taskid;
			MPI_Send(&taskid, 1, MPI_INT, partner, 1, MPI_COMM_WORLD);
			MPI_Recv(&message, 1, MPI_INT, partner, 1, MPI_COMM_WORLD, &status);
		}
		else if(taskid == numtasks/2) {
			partner = taskid - numtasks / 2;
			MPI_Recv(&message, 1, MPI_INT, partner, 1, MPI_COMM_WORLD, &status);
			MPI_Send(&taskid, 1, MPI_INT, partner, 1, MPI_COMM_WORLD);
		}
		
		cout << "Task " << taskid << " is partner with " << message << endl;
	}		
			
	
	MPI_Finalize();
}
