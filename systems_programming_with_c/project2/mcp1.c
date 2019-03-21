/* mcp1.c
 * Alexandre Castro
 */

#define O_WRONLY 1
#define O_CREAT 0100

int main(int argc, int** argv){

  char buffer;
  

    open(argv[1], 0);
    open(argv[2], (O_CREAT | O_WRONLY), 0600);
    while(read(3, &buffer, 1)){
      write(4, &buffer, 1);
    }
 

  return 0;
}
