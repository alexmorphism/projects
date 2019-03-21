/*  client1.c  
 *  next letter client: inet domain
 */

#include <sys/socket.h>
#include <sys/types.h>
#include <sys/un.h>
#include <stdio.h>
#include <unistd.h>

#include <netinet/in.h>
#include <arpa/inet.h>

int main(void) {

    char letter = 'A';
    int socket_fd;
    
    struct sockaddr_in address;   //note un --> in change
    address.sin_family = AF_INET;
    address.sin_addr.s_addr = inet_addr("192.168.31.38");
    address.sin_port = 9742;
    address.sin_port = htons(9742);
       
    //the following the same as client.c
    int len = sizeof(address);
    
   while(1) {
      socket_fd = socket(AF_INET, SOCK_STREAM,0);  //UNIX -> INET
      connect(socket_fd,(struct sockaddr*)&address, len); 
    
      printf("letter to send: "); fflush(stdout);
      read(0,&letter,1);
      write(socket_fd,&letter,1);
      read(socket_fd,&letter,1);
      printf("server replies with: %c\n", letter); fflush(stdout);
      read(0, &letter,1);   //eat newline
      close(socket_fd);
    }
    return 0;   
}
