/* fork0a.c 
 * Alexandre Castro
 */

#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main(void){
	printf ("before fork: prgram process ID is %d\n", (int) getpid());
	fork();
	printf ("after fork: program process ID is %d\n", (int) getpid());

}