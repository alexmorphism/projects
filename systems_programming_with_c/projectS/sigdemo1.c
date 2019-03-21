/* sigdemo1.c
 * This program's behaviour is different if compiled with c99
 * Compare the behaviour with both
 * 1.  gcc -std=c89 sigdemo1.c -o sigdemo1
 * 2.  gcc -std=c99 sigdemo1.c -o sigdemo1
 *
 * Alexandre Castro
 * 11/08/18
 * System Programming with C 
 */

#include <stdio.h>
#include <signal.h>
#include <unistd.h>

void handler (int signum);

int main(void) {

	signal(SIGINT, handler);
	/*this system call makes handler() the response to SIGINT
	  does not reset in c99, handles just 1 call */

	while(1) {
		printf("hello\n");
		sleep(1);
	}

}

void handler(int signum){
	printf("OUCH!\n");
	/* signal (SIGINT, handler);
	  this resets handler to handle more calls with C99 */
}