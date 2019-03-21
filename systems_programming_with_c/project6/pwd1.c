/* pwd1.c
 * Alexandre Castro
 * 
 * This program produces the same version of pwd
 */
 
#include <dirent.h>
#include <string.h>
#include <unistd.h>
#include <stdio.h>

int printPath();

int main(int argc, char** argv){
    if(!printPath()) //if printpath is false print /
        printPath();
    else
        printf("/");
    
    //printPath();
    printf("\n");
    //printf("heloo");
}

int printPath(){

    struct dirent* entry; //formats directory entries
    DIR* dir; //child directory
    DIR* pdir; //parent directory
    long inode; //child inode
    long pinode; //parent inode

    dir  = opendir("."); //opens the current directory, 
    pdir = opendir(".."); //returning a pointer to the directory stream

    //reads all entries in the current directory
    while((entry = readdir(dir)) != NULL){

        if(!strcmp(entry->d_name, ".")) {
            inode = entry->d_ino; //retrieves the child inode#
            break;
        }       
    } 

    //reads all entries in the parent directory
    while((entry = readdir(pdir)) != NULL){

        if(!strcmp(entry->d_name, "..")) {
            pinode = entry->d_ino; //retrieves the parent inode#
            break;
        }       
    }
    /* BASE CASE
     * compares if the parent and child's inode numbers are the same*/
    if(inode == pinode){
        //do nothing and return
        //printf("slash");
        return 1;
    } 
    //RECURSIVE CASE
    else {
        chdir(".."); //change to a parent directory
        printPath(); //call recursive method
        printf("/");

        /* reads all entries in the parent directory,
         * printing the name of the directory to the console.*/
        while((entry = readdir(pdir)) != NULL){

            if(entry->d_ino == inode) {
                printf("%s", entry->d_name);
                break;
            }       
        }

    }
    return 0;
}//end function
