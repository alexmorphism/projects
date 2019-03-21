/* msh3.c towards a small command interpreter:
 * converts command line into array of tokens which wxecvp can understand
 *
 * Alexandre Castro
 * 10/31/18 CS212
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>


int main(void){
	int bytes_in_line;
	char* input_line;
	int line_length = 100;

	input_line = (char*) malloc(line_length + 1);

	printf("|msh> ");
	bytes_in_line = getline(&input_line, &line_length, stdin);
	printf("%s\n", input_line);

	char* command[10];
	char* token;
	token = strtok(input_line, " ");
	int token_index = 0;
	while(token != NULL){
		command[token_index] = token;
		printf("token: %s command[%d]: %s\n", token, token_index, command[token_index]);
		token = strtok(NULL, " ");
		token_index++;
	}
	printf("token_index: %d\n", token_index);
	char* last_token = command[token_index - 1];
	int length = strlen(last_token);
	command[token_index -1][length - 1] = 0;
	command[token_index] = 0;
	execvp(command[0], command);
}
