/* orphan0.c 
 * A cruel program which creates orphans by
 * ensuring that their parents die young
 */

//#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(void){
	long pid;
	char* message;
	int count;
	long time_to_sleep;

	printf("Child born now\n");
	pid = fork();

	if (pid == 0){
		message = "I am the child!";
		count = 20;
		time_to_sleep = 2;
		printf("%s My pid is %d \n", message, getpid());
		
		
	} 

	else{ //parent gets child's pid
		message = "I am the parent!";
		printf("%s My pid is %d \n", message, getpid());
		printf("Parent leaving; child becomes orphan");
		exit(42);
	}

	while (count > 0){
		printf("%s My pid is %d; My parent's pid is %d", message, 
			getpid(), getppid());
		if(getppid() == 1)
			printf(" I have been adopted\n");
		printf("\n");
		sleep(time_to_sleep);
		count--;
	}
	exit(0);
}