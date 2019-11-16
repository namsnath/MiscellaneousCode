#include<stdio.h>
 
typedef struct
{
    int pid;
    int burst_time;
    int waiting_time;
    int turnaround_time;    
    int priority;
} process;
 
void print_table(process p[], int n)
{
    int i;
 
    puts(" PID  Burst Time  Waiting Time  Turnaround Time ");
 
    for(i=0; i<n; i++) {
        printf(" %2d\t%2d\t%2d\t%2d\t%2d\n"
               , p[i].priority, p[i].pid, p[i].burst_time, p[i].waiting_time, p[i].turnaround_time );
    }
 
}
 
void print_gantt_chart(process p[], int n)
{
    int i, j;
    // printing process id in the middle
    for(i=0; i<n; i++) {
        for(j=0; j<p[i].burst_time - 1; j++) printf(" ");
        printf("P%d", p[i].pid);
        for(j=0; j<p[i].burst_time - 1; j++) printf(" ");
        printf("|");
    }
    printf("\n ");
 
    // printing the time line
    printf("0");
    for(i=0; i<n; i++) {
        for(j=0; j<p[i].burst_time; j++) printf("  ");
        if(p[i].turnaround_time > 9) printf("\b"); // backspace : remove 1 space
        printf("%d", p[i].turnaround_time);
 
    }
    printf("\n");
 
}
 
void sort(process arr[],int n)
{
    int minp,i,j;
    process min;    
 
    for(i=0;i<n;i++)
    {
        min = arr[i];
        minp = i;
        for(j=i+1;j<n;j++)
        {
            if(arr[j].priority < min.priority)
            {
                min = arr[j];
                minp = j;
            }
        }
        
        arr[minp] = arr[i];
        arr[i] = min;   
    }
}           
 
void read(process *a,int i)
{
    a->pid = i+1;
    
    printf("Enter burst time : ");
    scanf("%d",&a->burst_time);
 
    printf("Enter priority : ");
    scanf("%d",&a->priority);
}
 
int main()
{
    int n,i;
    printf("Enter number of processes to consider : ");
    scanf("%d",&n);
    
    process arr[n];
    for(i=0;i<n;i++)
       read(&arr[i],i);
 
    sort(arr,n);
    int time = 0;
    for(i=0;i<n;i++)
    {
        arr[i].waiting_time = time;
        time += arr[i].burst_time;
        arr[i].turnaround_time = time; 
    }
    
 
    int sum_waiting_time=0,sum_turnaround_time=0;
    for(i=0; i<n; i++)
    {
            sum_waiting_time += arr[i].waiting_time;
            sum_turnaround_time += arr[i].turnaround_time;
        }
 
    // print table
        puts(""); // Empty line
        print_table(arr, n);
        puts(""); // Empty Line
        printf("Total Waiting Time      : %-2d\n", sum_waiting_time);
        printf("Average Waiting Time    : %-2.2lf\n", (double)sum_waiting_time / (double) n);
        printf("Total Turnaround Time   : %-2d\n", sum_turnaround_time);
        printf("Average Turnaround Time : %-2.2lf\n", (double)sum_turnaround_time / (double) n);
 
        // print Gantt chart
        puts(""); // Empty line
        print_gantt_chart(arr, n);
        return 0; 
}

