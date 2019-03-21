/* waiting1.c 
 * puts child and parent actions into functions
 */

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

#define NAP_TIME 5

void child_acts(int time);
void parent_acts(int child_pid);

int main(void){
	int pid;
	printf("starting: pid is %d\n", getpid());  //new system call

	pid = fork();

	if(pid == 0)
		child_acts(NAP_TIME);
	else
		parent_acts(pid);

	return 0;
}

void child_acts(int time){
	printf("child id: %d. Child napping for %d seconds \n", getpid(), time);
	sleep(time);
	printf("nap over; child exiting\n");
	exit(42);
}

void parent_acts(int child_pid){
	int wait_result;
	printf("Parent (id: %d) waiting til child's nap over\n", getpid());
	wait_result = wait(NULL);
	printf("Parent (id: %d) stops waiting on child (id %d) result = %d\n",
		getpid(), child_pid, wait_result);
}