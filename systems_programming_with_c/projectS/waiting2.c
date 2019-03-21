/* waiting2.c
 * Exibits the information provided by wait
 * Alexandre Castro
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
	printf("Starting: pid is %d\n", getpid());

	pid = fork();
	if (pid == 0)
		child_acts(NAP_TIME);
	else
		parent_acts(pid);

	return 0;
}

void child_acts(int time){
	printf("child id: %d. Child taking a nap for %d seconds\n", getpid(), time);
	sleep(time);
	printf("nap over; child exiting\n");
	exit(42);
}

void parent_acts(int child_pid){
	int wait_result;
	int child_status;
	printf("Parent (id: %d) waiting til child's nap over\n", getpid());
	wait_result = wait(&child_status);
	printf("Parent (id: %d) stops waiting for child (id: %d) result = %d\n",
		getpid(), child_pid, wait_result);

	int high_8 = child_status >> 8; /*selects 1-bits 1111 1111 0000 0000 */
	int low_7 = child_status & 0x7F; /* slects 0x7F = 0000 0000 0111 1111 */
	int bit_7 = child_status & 0x80; /* selects 0x80 = 0000 0000 1000 0000 */
	printf("child status: exit code = %d, signal caught = %d, core dump? = %d\n",
		high_8, low_7, bit_7);
}