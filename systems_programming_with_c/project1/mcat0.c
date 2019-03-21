/*
 * mcat0.c
 * This program will reproduce a version of the cat command
 * It should take zero up to any number of files through the command argument
 */

int main(int argc, char** argv){
  char buffer;
    
 for(int i = 1; i < argc; i++){
  open(argv[i], 0);
  while(read(3,&buffer,1)){
    write(1, &buffer, 1);
  }
  close(3);
 }
    
  return 0;
}
