#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#define window 3

int doReceiver();
int doSender();

int sent[100];
int expected = 0;
int windowPos = 0;

void main() {
	int frameCount;
	int data[100];
	int i, j = 0, send, rcv;

	printf("Enter number of frames to send: ");
	scanf("%d", &frameCount);

	for(i = 0; i < frameCount; i++) {
		data[i] = rand()/2000000;
	}

	for(i = 0; i < frameCount; i++) {
		printf("%d\t", data[i]);
	}

	while(j < frameCount) {
		printf("\n\nSending Frames %d-%d\n", windowPos, windowPos+window);
		for(i = windowPos; i < windowPos + window; i++) {
			printf("Sending data = %d\n", data[i]);

			sent[i] = doSender(data[i], i);
			// if(send < 0) {
			// 	printf("Frame %d Lost\n", i);
			// 	continue;
			// }

			// rcv = doReceiver(send, i, rcvFrame);
			
			// if(rcv < 0) {
			// 	printf("Ack Lost, sending frames %d-%d again\n", windowPos, windowPos + window);
			// 	i = windowPos;
			// } else {
			// 	printf("Received Ack for = %d\n", rcv);
			// 	i = i + rcv + 1;
			// 	rcvFrame = windowPos + rcv;
			// 	if((windowPos + window + rcv) < frameCount)
			// 		windowPos += rcv;
			// }
		}
		int add = doReceiver();
		printf("Good frames received = %d\n", add);
		if((windowPos + window + add) <= frameCount)
			windowPos += add;
	}	
}

int doSender(int data, int frame) {
	int choice;
	printf("What would you like to do?\n");
	printf("1 - Send Data\n");
	printf("2 - Send and Lose Data\n");
	scanf("%d", &choice);

	switch(choice) {
		case 2: return -1*data;
		default: return data;
	}
}

int doReceiver() {
	int add = 0, i;
	printf("Receiver Side:\n");
	// printf("Add = %d\n", add);
	for(i = windowPos; i <= window + windowPos; i++) {
		// printf("%d ", i);
		if(sent[i] < 0)
			return add;
		if(i <= expected) {
			add++;
			expected++;
			// printf("\nAdd = %d\n", add);
		}	
	}
	return add;
}