/* pwd0.c
 * Alexandre Castro
 * 
 * This program produces the same version of pwd
 */
 
#include <dirent.h>
#include <string.h>
#include <unistd.h>


int main(int argc, char** argv){
    
    struct dirent* entry;
    DIR* dir;

    long inode;

    dir = opendir(".");

    while((entry = readdir(dir)) != NULL){

        if(!strcmp(entry->d_name, ".")) {
            inode = entry->d_ino;
            break;
        }
    }

    dir = opendir("..");

    while((entry = readdir(dir)) != NULL){
        if(inode == entry->d_ino){
            write(1, entry->d_name, strlen(entry->d_name));
            write(1, "\n", 1);
            break;
        }
    }
}

