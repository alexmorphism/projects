/* mwrite1.c
 * Alexandre Castro
 */

#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <stdlib.h>


int main(int argc, char* argv[]){
	

	char buffer;

	open(ttyname(0), 0);

	if( open(argv[1], 1) < 0) {
		printf("mwrite: %s is not logged in\n", argv[1]);
		perror("");
		exit(1);
	}

	while( read(3, &buffer, 1) > 0){
		write(4, &buffer, 1);
	}

	return 0;

}