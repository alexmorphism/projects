/* mwho0.c
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



int main(int argc, char* argv[]){
 
    struct utmp utmp1;
     
    int fd = open("/var/run/utmp", 0);
    
    while(read(fd, &utmp1, sizeof(utmp1)) > 0){   
        if(utmp1.ut_type == USER_PROCESS){    
            printf("%s", utmp1.ut_user);
            printf("\t %s", utmp1.ut_line);
            printf("\t (%s)\n", utmp1.ut_host);//ip address
        }
    }      
        
}       
