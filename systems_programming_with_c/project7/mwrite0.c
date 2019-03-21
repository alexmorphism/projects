/* mwrite0.c
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
#include <pwd.h>
#include <string.h>

int main(int argc, char* argv[]){
    struct utmp utmp1;
    struct passwd* pw;
    struct tm* tm1;

    char* tty;
    char* userid;
    long current_time = time(NULL);

    int fd = open(argv[1], 0);
    int fd1 = open("/var/run/utmp", 0);

    tty = ttyname(fd); //returns the name of the terminal


    while(read(fd1, &utmp1, sizeof(utmp1)) > 0){
    	current_time = utmp1.ut_time; 
    	tm1 = localtime(&current_time); //gets the local time
    	printf("%s\n", utmp1.ut_line);

    	if(!strcmp(tty + 5, utmp1.ut_line)){
    		userid = utmp1.ut_user;
    	}
    }

      //pw = getpwuid(userid); //get's the sender's username given the user ID number

    

    //int hostname = gethostname(&userid, sizeof(userid));

    printf("Mesage from %s on %s at %d:%d ...\n", userid, tty, tm1->tm_hour, tm1->tm_min);
   // write(username, tty, 1);



//write: username is not logged in on pts/3


}