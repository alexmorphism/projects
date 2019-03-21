/* run0sys.c   A program that runs other programs!
 * Must run with absolute path: /bin/ps, for example, as first arg.
 *
 * Alexandre Castro
 *
 */

 #include <unistd.h>

int main(int argc, char* args[], char* envp[]){
	write(1, "Get ready!\n\n", 12);
	//execve("/bin/ps", args + 1, envp);  //example of full path to ps
	execve(args[1], args + 1, envp);
	write(1, "Do you see this?\n", 17);
	return 0;
}