/* waiting0.c
 * illustrates use of new system call: wait
 * Alexandre Castro
 */

#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>

#define NAP_TIME 5

int main (void){
	int pid;
	printf("starting: pid is %d\n", getpid()); //new system call

	pid = fork();

	if(pid == 0){
		printf("child id: %d Child napping for %d seconds\n", getpid(), NAP_TIME);
		sleep(NAP_TIME);
		printf("nap over; child exiting\n");
		exit(42);
	}
	else{                      //parent: pid > 0
		int wait_result;
		printf("Parent id: %d waiting util child's nap over\n", getpid());
		//sleep(NAP_TIME);
		wait_result = wait(NULL);
		printf("Parent (id: %d) stop waiting for child (id: %d) result = %d\n",
			getpid(), pid, wait_result);
	}
	return 0;
}