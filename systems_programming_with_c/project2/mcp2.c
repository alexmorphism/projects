/* mcp2.c
 * Alexandre Castro
 */

#define O_WRONLY 1
#define O_CREAT 0100

int main(int argc, int** argv){

  char buffer[1000000];
  

    open(argv[1], 0);
    open(argv[2], (O_CREAT | O_WRONLY), 0600);
    while(read(3, &buffer,1000000)){
      write(4, &buffer, 1000000);
    }
 

  return 0;
}
