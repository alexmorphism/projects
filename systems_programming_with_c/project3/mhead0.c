/* mhead0.c
 * Alexandre Castro
 * 10/02/18
 * 
 * This program is designed to produce the same functionality as the head
 * command argument on the command line
 * This program doesn't take any options, but it prints 10 lines to stdout
 *
 */
 
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#define BUFSIZE 1048 //BUFFER SIZE
#define L_COUNT 10 //LINE COUNT

int main(int argc, char** argv){
  char buffer[BUFSIZE];
  int count;
  char  c;
  int bytes_read;

  for(int i = 1; i < argc; i++){
  //prints the name of the file if there is more than one file passed as an argument.
    if(argc > 2){
      write(1,"==> ",4);
      write(1, argv[i], strlen(argv[i]));
      write(1," <==\n",5);
      }
      
    int fd = open(argv[i], 0);
    count = 0;
    while((bytes_read = read(fd, &buffer, BUFSIZE)) > 0 && count != L_COUNT)
    {
      int j;
      for(j = 0; j < bytes_read; j++)
      {
        if(buffer[j] == '\n')
          count++;
        if(count == L_COUNT){
          j++;
          break;
        }
      }
      
      write(1, &buffer, j);
      
    }
    close(fd);
    //prints a new line if the number of arguments are greater than two
    //and the loop index variable is less than the number of argument minus 1
    if(argc > 2 && i < argc-1)
      write(1, "\n", 1);    
  }
}
