/* msh0.c
 * Alexandre Castro
 *
 * towards a small command interpreter:
 * 		demonstrates 1. malloc
 *					 2. getnile
 */ 

#include <stdio.h>
#include <stdlib.h>

int main(void){

	int bytes_in_line;
	char* input_line;
	int line_length = 100;

	input_line = (char*) malloc(line_length + 1); //new system call malloc

	printf("|msh> ");

	bytes_in_line = getline(&input_line, &line_length, stdin);
								//getline is a useful GNU library function

	printf("bytes: %d\n", bytes_in_line);
	printf("%s\n", input_line);

}