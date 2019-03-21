/**
 * Stack.java
 * @author Alexandre Castro
 * 10-17-18 Data Structure CS2208
 * 
 * This is the Stackk class named "Stackk" not to be confused with the original java api stack.
 * The Stackk class is type Object, designed to take any type of of Object implementation.
 * It provides crucial methods such as push, pop, and peek as well as helper methods.
 * 
 * I chose to use my own version of stack because I'm interested in learning how to implement this legendary old ADT data structure 
 * which is used in many applications. Such as how files are store in memory.
 * 
 */
public class Stackk{
  
  private int maxSize, top;
  private Object[] stackArray;
  
  /*********CONSTRUCTORS***********/
  public Stackk(){
    maxSize = 10;
    top = -1;
    stackArray[maxSize] = new Object();
  }
  
  public Stackk(int size){
    maxSize = size;
    stackArray = new Object[maxSize];
    top = -1;
    
  }
  
  /***************METHODS*********/
  
  public int getMaxSize(){
    return maxSize;
  }
  
  public int getTop(){
    return top;
  }
  
  
  public void push(Object obj){
    if(isFull()){
      System.out.println("The stack is full and can't add anymore items\n");
    }
    else{
      top++;
      stackArray[top] = obj;
    } 
  }
  
  public Object pop(){
    
    if(isEmpty()){
      System.out.println("The stack is empty.");
      return null;
    }
    else{
      int old = top;
      top--;
      return stackArray[old]; 
    }
  }
  
  public Object peek(){
    if(isEmpty()){
      System.out.println("The stack is empty, nothing to peak\n");
      return null;
    }
    else{
      return stackArray[top];
    }
  }
  
  //if the stack is empty it returns true.
  //otherwise returns false.
  public boolean isEmpty(){
    return (top == -1);
  }
  
  //if the stack is full returns true, otherwise returns false
  public boolean isFull(){
    return (maxSize -1 == top);
  }
  
}
