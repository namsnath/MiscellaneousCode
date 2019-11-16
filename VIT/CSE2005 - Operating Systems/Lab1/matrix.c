#include <stdio.h>
int main() {
	int ch = 1, i, j, k;
	int a[3][3], b[3][3], c[3][3];

	printf("Enter the first matrix, row-wise\n");
	for(i = 0; i < 3; i++)
		for(j = 0; j < 3; j++)
			scanf("%d", &a[i][j]);
		
		for(i = 0; i < 3; i++) {
			for(j = 0; j < 3; j++)
                        	printf("%d\t", a[i][j]); 
                        printf("\n");
                }

	printf("Enter the second matrix, row-wise\n");
        for(i = 0; i < 3; i++)
                for(j = 0; j < 3; j++)
                        scanf("%d", &b[i][j]);


	for(i = 0; i < 3; i++)
		for(j = 0; j < 3; j++)
		c[i][j] = 0;

	do {
		printf("Enter choice: \n1 - Add\n2 - Subtract\n3 - Multiply");
		scanf("%d", &ch);
		switch(ch) {
			case 1:	
				for(i = 0; i < 3; i++)
					for(j = 0; j < 3; j++)
						c[i][j] = a[i][j] + b[i][j];

				printf("Result = \n");
				for(i = 0; i < 3; i++) {
					for(j = 0; j < 3; j++)
						printf("%d\t", c[i][j]);
					printf("\n"); 
				}
			break;

                        case 2:
                                for(i = 0; i < 3; i++)
                                        for(j = 0; j < 3; j++)
                                                c[i][j] = a[i][j] - b[i][j];

                                printf("Result = \n");
                                for(i = 0; i < 3; i++) {
                                        for(j = 0; j < 3; j++)
                                                printf("%d\t", c[i][j]);
                                        printf("\n");
                                }
			break;

			case 3:
				for(i = 0; i < 3; i++) {
					for(j = 0; j < 3; j++) {
						for(k = 0; k < 3; k++)
							c[i][j] += a[i][k] * b[k][j];
					}
				}

                                printf("Result = \n");
                                for(i = 0; i < 3; i++) {
                                        for(j = 0; j < 3; j++)
                                                printf("%d\t", c[i][j]);
                                        printf("\n");
                                }
                        break;


		}
		break;
	} while(ch > 0 && ch < 4);
}


