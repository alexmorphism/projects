/* mhead1.c
 * Alexandre Castro
 * 10/02/18
 * 
 * This program is designed to produce the same functionality as the head
 * command argument on the command line
 * mhead1.c adds options to write the document by bytes or line numbers. 
 */
 
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <getopt.h>
#include <ctype.h>
#include <string.h>

#define BUFSIZE 1048 //BUFFER SIZE
#define L_COUNT 10 //LINE COUNT

int main(int argc, char* argv[]){
  char buffer[BUFSIZE];
  int count = 0;
  int bytes_read;
  int number;
  int flag = 0;
  int file_count = 0;
  char* optionstring = "c:n:";
  
  int option = getopt(argc, argv, optionstring);
  int lastoption; 
  if(option == '?'){
    printf("Try watching Help! for inspiration.\n");
    exit(1);
  }
  //if there are no options set the number of lines to 10. 
  if(option < 0){
    number = 10;
    flag = 1;
  }
  
//loop while there are no more options.
  while(option > 0 )
  {
      int isnumber = 1;
      if (optarg != NULL) {
        for (int i = 0; i < strlen(optarg); i++) {
          if (!isdigit(optarg[i])){
              printf("bad option argument\n");
              isnumber = 0;
              break;
          }
        }
        if (isnumber) {       
          number = atoi(optarg);//optarg is a char* pointer to option argument  
          lastoption = option;
         }
      }
      option = getopt(argc,argv, optionstring);  //next option
  }
  
    if(lastoption == 'n' || flag){ //*********read the lines*******
    file_count = argc - file_count;
      for(int i = optind; i < argc; i++){
        if(file_count > 2){
          write(1, "==> ", 4);
          write(1, argv[i], strlen(argv[i]));
          write(1, " <==\n", 5);
        }
        
        int fd = open(argv[i], 0);
        count = 0;
        while((bytes_read = read(fd, &buffer, BUFSIZE)) > 0 && count != number){
          int j;
          for(j = 0; j < bytes_read; j++){
            if(buffer[j] == '\n')
              count++;
            if(count == number){
              j++;
              break;
            }
          }
          write(1, &buffer, j);
        }
        if(file_count > 2 && i < argc-1)
          write(1, "\n",1);
        close(fd);  
      }            ///*******read lines end*************
    }
    
    if(lastoption == 'c'){
    file_count = argc - file_count;    
      for(int i = optind; i<argc; i++){
        if(file_count > 1){
          write(1, "==> ", 4);
          write(1, argv[i], strlen(argv[i]));
          write(1, " <==\n", 5);
        }
        int fd = open(argv[i], 0);
        count = 0; 
        while((bytes_read = read(fd, &buffer, BUFSIZE)) > 0 && count != number){
        int j;
          for(j = 0; j < bytes_read; j++){
            if(buffer[j] == 1){
              //chars_read++;
              count++;
            }
            if(count == number){
              j++;
              break;
            }       
          }
          write(1, &buffer, number);
          if(file_count > 2 && i < argc-1){
            write(1, "\n",1); 
          }         
        }       
      }
    }



}
