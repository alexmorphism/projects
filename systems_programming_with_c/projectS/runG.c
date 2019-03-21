/* runG.c a program that runs other programs!
 * Alexandre Castro
 */

#include <unistd.h>

int main(int argc, char** args){
	write(1, "Get ready!\n\n",12);
	execvp(args[1], args + 1);  //library wrapper for execve system call

	write (1, "Ghosts\n", 17);
	return 0;

}