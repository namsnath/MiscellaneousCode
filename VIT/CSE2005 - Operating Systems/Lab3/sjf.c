#include<stdio.h>
 
struct process
{
  int pid;
  int waiting;
  int turnaround;
  int burst;
  int es;   //execution start
  int ee;   //execution end 
};
 
struct process read(struct process p,int i)
{
    p.pid = i+1;
    printf("P[%d] : ",p.pid);
    scanf("%d",&p.burst);
    p.es = 0;
    p.ee = 0;
    return p;
}
 
void sort(struct process arr[],int n)
{
    int i,j,minp;
    struct process min,temp;
    for(i=0;i<n;i++)
    {
        min = arr[i];
        minp = i;
        for(j=i+1;j<n;j++)
        {
            if(arr[j].burst<min.burst)
            {
                min = arr[j];
                minp = j;
            }
        }
        arr[minp] = arr[i];
        arr[i] = min;
    }
}
 
int main()
{
    int n,i;
    printf("Enter number of processes to consider : ");
    scanf("%d",&n);
    
    struct process arr[n];
    printf("Enter burst time of each process: \n");  
    for(i=0;i<n;i++)
       arr[i] = read(arr[i],i); 
 
    sort(arr,n);
 
    int time=0;
    for(i=0;i<n;i++)
    {
        arr[i].es = time;
        time += arr[i].burst;
        arr[i].ee = time;
    }
    
    for(i=0;i<n;i++)
    {
        arr[i].waiting = arr[i].es;
        arr[i].turnaround = arr[i].ee;
    }
    
    printf("\n\nPID\tBurst\tStart\tEnd\tWaiting\tTurnaround\n");
    for(i=0;i<n;i++)
       printf("%d\t%d\t%d\t%d\t%d\t%d\n",arr[i].pid,arr[i].burst,arr[i].es,arr[i].ee,arr[i].waiting,arr[i].turnaround);
    
    int totalwait=0,totalturn=0;
    for(i=0;i<n;i++)
    {
        totalwait += arr[i].waiting;
        totalturn += arr[i].turnaround;
    }
 
    float avgwait = totalwait/n;
    float avgturn = totalturn/n;
 
    printf("\nAverage waiting time = %.2f\nAverage Turnaround time = %.2f\n",avgwait,avgturn);
 
}

