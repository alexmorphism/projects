/* fork2.c
 * Alexandre Castro
 */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(void){
	int pid;
	char* message;
	int count;
	int speed;

	printf("Forking now\n");
	pid = fork();
	printf("printf pid = %d\n", pid);
	if(pid == 0){
		message = "I am the child!";
		count = 9;
		speed = 1;
	}
	else { //patent gets child's pid
		message = "I am the parent!";
		count = 3;
		speed = 2;
	}

//THIS POINT draw diagram
	while(count > 0 ){
		printf("%s", message);
		printf("\n");
		sleep(speed);
		count--;
	}

	if (pid == 0){
		printf("Child leaving now!\n");
	}
	else{
		printf("Parent leaving now!\n");
	}
	exit(0);
}