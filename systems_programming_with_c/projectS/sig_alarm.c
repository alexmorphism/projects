/* sig_alarm.c
 * shows how to awaken a sleeping process after
 * a specifies period of time.
 */

#include <stdio.h>
#include <signal.h>
#include <unistd.h>


void alarm_handler(int signum);

int main(void) {

	printf("Going to sleep for 4 seconds\n");
	signal(SIGALRM, alarm_handler);
	signal(SIGALRM, SIG_IGN);
	//with both signal calls commented out alarm zaps the process
	alarm(4);
	pause();
	printf("Now that's a catnap!\n");
}

void alarm_handler(int signum){
	printf("Alarm!");
}