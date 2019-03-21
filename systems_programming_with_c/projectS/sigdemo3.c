/* sigdemo3.c
 * shows how to respond to more than one signal
 * 1.  gcc -std=c89 sigdemo3.c -o sigdemo3
 * 2.  gcc -std=c99 sigdemo3.c -o sigdemo3
 */

#include <stdio.h>
#include <signal.h>
#include <unistd.h>

#define INPUTLEN 100

void inthandler(int signum);
void quithandler(int signum);

int main(int ac, char* av[]) {
	char input[INPUTLEN];
	int nchars;

	signal(SIGINT, inthandler);
	signal(SIGQUIT, quithandler);

	do{
		printf("\nType a message\n");
		nchars = read(0, input, INPUTLEN -1 );
		input[nchars] = '\0';
		printf("You typed: %s", input);
	}
	while( strncmp(input, "quit", 4) != 0);

}

void inthandler(int signum){
	printf("inthandler got signal %d .. waiting\n", signum);
	sleep(2);
	printf("  Leaving inthandler \n");
}

void quithandler(int signum){
	printf("quithandler got signal %d .. waiting\n", signum);
	sleep(3);
	printf("  Leavinf quithandler \n");
}
