/* zombie0.c 	Makes a zombie  */

//#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(void){
	long pid;
	char* message;
	int count;
	long time_to_sleep;

	printf("Forking now\n");
	pid = fork();

	if (pid == 0){
		message = "I am the parent!";
		count = 1;
		time_to_sleep = 1;
	} 
	else{ //parent gets child's pid
		message = "I am the parent!";
		count = 10;
		time_to_sleep = 30;
	}

	while (count > 0){
		printf("%s", message);
		printf("\n");
		sleep(time_to_sleep);
		count--;
	}

	if (pid == 0) {
		printf("Child leaving now!\n");
	}
	else {
		printf("Parent leaving now!\n");
	}
	exit(0);
}