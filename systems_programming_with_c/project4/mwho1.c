/* mwho1.c
 * 
 * Alexandre Castro
 */
 
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <utmp.h>
#include <stdlib.h>
#include <time.h>



int main(int argc, char* argv[]){
 
    struct utmp utmp1;
    struct tm* tm1;
    char buffer;

    long current_time = time(NULL);
    

    int fd = open("/var/run/utmp", 0);

    while(read(fd, &utmp1, sizeof(utmp1)) > 0){
    	current_time = utmp1.ut_time; 
    	tm1 = localtime(&current_time);

        if(utmp1.ut_type == USER_PROCESS){    
            printf("%s\t ", utmp1.ut_user);
            printf("%s", utmp1.ut_line); //prints tty..
            printf("\t      %d-", tm1->tm_year + 1900); //prints year
            printf("%d-", tm1->tm_mon + 1); //prints month number
            printf("0%d", tm1->tm_mday); //prints month day
            printf(" %d", tm1->tm_hour); //prints hour
            printf(":%d", tm1->tm_min); //prints min
            printf(" (%s)\n", utmp1.ut_host);//ip address
        }
    }      
        
}       
