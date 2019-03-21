/* fork0B.c 
 * Alexandre Castro
 */

#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main(void){
	printf("before forks: program process ID is %d\n", (int) getpid());
	fork();
	printf("between forks: program process ID is %d\n", (int) getpid());
	if(fork() > 0){
		printf("forking sometimes\n");
		fork();
	}
	
	//fork();
	printf("after forks: program process ID is %d\n", (int) getpid());


}