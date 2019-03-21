/* msh10.c a mini shell
 * 
 * Alexandre Castro
 * 11/16/18 
 * Systems Programming with C
 */
#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>

#define CMD_LENGTH 100
#define TOKENS 10

void command_stoa(char** command, char* command_text);
void mcd(char * path);

int main(void) {
	long line_size = CMD_LENGTH;
	char* input_line;
	input_line = (char*) malloc(CMD_LENGTH + 1);

	char* command[TOKENS];
	int cmd_pid;
	int cmd_status;

	//signal(SIGINT, SIG_IGN); //parent
	signal(SIGQUIT, SIG_IGN);
	while(1) {
		printf("|msh> ");

		getline(&input_line, &line_size, stdin);

		command_stoa(command, input_line);

		if(strcmp(command[0], "exit") == 0){
			exit(0);
		}

		//printf("%s", command[0]);

		if(strcmp(command[0], "cd") == 0){
			mcd(command[1]);
			continue;
		}
		cmd_pid = fork();

		if(cmd_pid == 0) {
			signal(SIGQUIT, SIG_DFL);
			signal(SIGINT, SIG_DFL);
			//command_stoa(command, input_line);
			execvp(command[0], command); //if fails, exit
			exit(0);
		}
		else{
			wait(&cmd_status);
		}
		
	}
}

void command_stoa(char** command, char* command_text) {
	char* token = strtok(command_text, " ");
	int token_index = 0;
	//char* token2 = "exit";
	while(token != NULL){
		command[token_index] = token;
		token = strtok(NULL, " ");
		token_index++;
	}

	char* last_token = command[token_index -1 ];
	int length = strlen(last_token);
	last_token[length -1] = 0;
	command[token_index] = 0;
}

void mcd(char* path){
	chdir(path);
}

