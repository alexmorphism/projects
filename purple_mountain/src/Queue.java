/* Queue.java
 * @author a_castro4
 * 10-17-18 Data Structure CS2208
 * 
 * This is the Queue class. It provides essential methods for inserting and removing objects into the queue.
 * It also has functionality to peek to the first item without removing.
 * The Queue class has helper methods, keeping track if the Queue is empty of full. 
 * 
 *  I chose to implement the Queue class because I'm interested in learning this data structure.
 *  My intention to write my own version of the Queue class instead of implementing the Queue interface in java. 
 *  I'm passionately to learn how it works so I can create my own version of Spotify (a music player software).
 *  
 */
public class Queue {
  private int front;
  private int rear;
  private int nItems;
  private int maxSize;
  private Object [] queueArray;
  
  
  public Queue(int size){
    this.maxSize = size;
    this.front = 0;
    this.rear = -1;
    this.queueArray = new Object[size];
  }
  
  public void insert(Object obj){ //insert an object in the queue. First come first serve
    
    if(isFull()){
      System.out.println("The line to go hiking for the day is FULL!");
    }else{
      rear++;
      queueArray[rear] = obj;
      nItems++;
    }
  }
  
  public Object remove(){ //removes an item from the queue, increase the front variable to point to the next in line.
    Object temp = queueArray[front];
    front++;
    
    if(isEmpty()){//if it reach the end of line and there is no one else to be removed. resuse the Array.
      System.out.println("There are no more people in the queue");
    }
    nItems--;
    
    return temp;
  }
  
  public Object peekFront(){ //looks at the first item on the queue
    Object temp = queueArray[front];
    
    return temp;
  }
  
  public boolean isFull(){ //checks if the queue is full
    return (nItems == maxSize);
  }
  
  public boolean isEmpty(){        
    return (nItems == 0);
  }
  
  //prints out what's in the Queue to the console
  public void view(){
    
    for(int i = 0; i < queueArray.length; i++){
      System.out.print(queueArray[i].toString());
    }
    
  }
  
}
