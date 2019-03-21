/* mls0.c
 * Alexandre Castro
 * 
 * This program produces the same version of ls
 */
 
#include <dirent.h>
#include <string.h>

#define NULL (void *)0

int main(int argc, char** argv){
    
    struct dirent* entry;
    DIR* dir;
    
        
    dir = opendir(".");
    entry = readdir(dir);
    
    while((entry = readdir(dir)) != NULL){
       
        if(entry->d_name[0] != '.') {
            write(1, entry->d_name, strlen(entry->d_name));
            write(1, "\n", 1);
        }
        
                   
    }
}
