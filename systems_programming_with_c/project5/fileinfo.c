/* mls0.c
 * Alexandre Castro
 * 
 */
 
#include <sys/stat.h>
#include <dirent.h>
#include <string.h>
#include <stdio.h>


int main(int argc, char* argv[]){
    
    struct stat buf;

    int result = stat(argv[1], &buf);
    printf("%ld\n%i\n%i\n%i\n%ld\n%ld\n%ld\n%ld\n",
        buf.st_mode, buf.st_uid, buf.st_gid, buf.st_size, 
        buf.st_nlink, buf.st_mtime, buf.st_atime, buf.st_ctime );       
}
