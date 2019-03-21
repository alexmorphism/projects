/* zombie_apocalypse.c 	Makes a zombie  */

//#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(void){
	long pid;
	char* message;
	int count = 0;
	int time_to_sleep;

	while(1){
		printf("Forking now\n");
		pid = fork();

		if (pid == 0) {
			message = "Child with ";
			printf("%s pid: %d", message, getpid());
			printf("Child   %d becomes zombie now", getpid());
			exit(42);
		}

		else{
			message = "Oh no! My children are becoming zombies!";
			printf("%s pid: %d", message, getpid());
			count++;
		}
	}

	exit(0);
}