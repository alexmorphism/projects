/* daemon.c
 * creates a daemon
 *
 * Alexandre Castro 
 * Halloween 2018
 */

#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>


int main(void){
	char* message;
	int pid = fork();
	if (pid == 0){
		message = "I, the child, will become parent of the daemon";
		printf("%s\n", message);
	}
	else{
		message = "Parent dies so that orphaned grandchild can become daemon";
		printf("%s\n", message);
		exit(42);
	}

	setsid();
	pid = fork();
	if (pid == 0){
		message = "I will become the daemon";
		printf("%s\n", message);
	}
	else{
		message = "Child dies so that its child can become daemon";
		printf("%s\n", message);
		exit(42);
	}

	umask(0);
	//chdir("/");
	printf("daemon started with pid %d\n", getpid());
	close(1);
	open("daemon_log", O_RDWR);
	printf("%s", "daemon starting log\n\n");
	message = "daemom here at ";
	time_t now;
	while(1){
		time(&now);
		printf("%s %s", message, ctime(&now));
		sleep(5);
	}

}