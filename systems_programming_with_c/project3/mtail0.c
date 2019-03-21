/* mtailo.c
 * Alexandre Castro
 * 10/02/18
 *
 * This program is designed to produce the same functionality as the tail
 * command argument on the command line
 * mtail.c ...
 */
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <getopt.h>
#include <ctype.h>
#include <string.h>

#define BUFSIZE 10    // eventually 8192
#define LINES   11      // test with 0, 1, ...
#define SUCCESS  0
#define STDOUT   1
#define STDIN    0

int main(int argc, char* argv[]){

    char buffer[BUFSIZE];
    int count;
    int bytes_read;
    int loc;
    int leap;
    
       
    for(int i = 1; i < argc; i++){
        int fd = open(argv[i],STDIN);   
        
        loc = lseek(fd, 0, SEEK_END); 

        if(loc > BUFSIZE){ 
           loc = lseek(fd, -BUFSIZE, SEEK_CUR); 
            leap = BUFSIZE;   
        }
        else if(loc < BUFSIZE){
            loc = lseek(fd, -loc, SEEK_CUR);
            leap = loc;   
        }

        count = 0;
        while( count != LINES && (( bytes_read = read(fd, &buffer, leap) ) > 0 ) ){
            int j;
            for(j = bytes_read; j > 0; j--){
                if(buffer[j] == '\n'){
                    count++;
                }

                if(count == LINES){
                    loc = lseek(fd, -bytes_read, SEEK_CUR);
                    loc = lseek(fd, j + 1, SEEK_CUR);
                    break;
                }               
            }

            if(count == LINES){
                break;
            }
            if(loc > BUFSIZE){
                loc = lseek(fd, -BUFSIZE, SEEK_CUR);
                leap = loc;
            }
            if(loc < BUFSIZE){
                loc = lseek(fd, -loc, SEEK_CUR);
                leap = loc;
            }

            loc = lseek(fd, -bytes_read, SEEK_CUR);

        }
         
        while((bytes_read = read(fd, &buffer, BUFSIZE)) > 0){

            write(1, &buffer, bytes_read);
        }
        
        printf("count = %d\n", count);
    }
    
}