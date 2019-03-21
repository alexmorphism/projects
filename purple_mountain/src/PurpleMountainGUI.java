/* App.java
 * Alexandre Castro
 * 10-17-18 Data Structure CS2208
 * 
 * This is the GUI class for the Purple Mountain application
 * This class simulates a mountain office login sheet that has three different hiking trail entrances.
 * It adds random number of hikers to an array of stacks, adding the stacks to queues randomly after.
 * After finishing adding the hikers, it lets 20 hikers each time out for hiking in the trails until there are no more hikers in the stacks and queues
 * In addition, this class writes the hikers information to a file.
 * At the end when Close Trails is pressed it writes the name of the hikers in the sign out sheet
 * Also it reinitializes the simulation for another day, resetting all it's attributes.
 *  
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PurpleMountainGUI extends Application {
  
  private static Stackk[] stack = new Stackk[100];
  private Queue[] queue = new Queue[3];
  
  private int[] hikerCount = new int[3]; //array of integers declared to be used to count hikers for each entrance.
  
  private static int index = 0;
  private int total_hikers = 1;
  private int random_hikers = 0;
  private int count = 0;
  private int mark = 0;
  private Random random = new Random(); 
  private String buffer = "";
  
  
  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    
    //button declaration
    Button start = new Button("Start");
    Button openTrial = new Button("Open Trial");
    Button closeTrials = new Button("Close Trials");
    
    //Enables and disable buttons for safety
    start.setDisable(false);
    openTrial.setDisable(true);
    closeTrials.setDisable(true);
    
    TextArea textArea = new TextArea(); //creates a text area
    
    creatStack(); //creates a first stack
    
    //initializes three queues
    queue[0] = new Queue(100);
    queue[1] = new Queue(100);
    queue[2] = new Queue(100);
    
    //initializes the hiker count arrays
    hikerCount[0] = 0;
    hikerCount[1] = 0;
    hikerCount[2] = 0;
    
    /*------------START--------------*/
    start.setOnAction(e->{
      textArea.clear();
      start.setDisable(true); //when start button is clicked it disables button
      openTrial.setDisable(false);
      
      try{
        random_hikers = random.nextInt(512 + 1 - 55 ) + 55;  //generates a random number of hikers (max + 1 - min) + min
        for(int i = 0; i< random_hikers; i++){
          
          if(stack[index].isFull()){               //if the current stack is full adds the stack to a queue randomly
            int ran = (int)(Math.random()*3);       //creates another stack to put more hikers
            queue[ran].insert(stack[index]);
            index++;
            creatStack();
          }
          
          stack[index].push(new Hiker("Hiker" + total_hikers));
          String str = ((Hiker)stack[index].peek()).toString();
          textArea.appendText(str);
          total_hikers++;
        }
        
        //adds the last Hiker's stack to the queue
        int ran = (int)(Math.random()*3);       
        queue[ran].insert(stack[index]);       
        
      }
      catch(ArrayIndexOutOfBoundsException e1){
        System.out.println(e1.getMessage());
      }
      
    });
    
    /*------------OPEN TRIALS--------------*/
    openTrial.setOnAction(e->{
      textArea.appendText("\n---Opening Trials---\n");
      
      PrintWriter writer = null;
      String file_name = "signIN.txt";
      
      try {
        writer = new PrintWriter(new FileWriter(file_name), true); // initializes a file writer with append status true
        
        for (int i = 0; i< queue.length; i++){
          while(!queue[i].isEmpty() && count < 20){ //while the current queue is not empty remove stacks
            Stackk st = (Stackk)queue[i].remove();
            
            while(!st.isEmpty()){ //while the stack is not empty pop each hiker from the stack
              Object hiker = (Hiker) st.pop();
              hikerCount[i]++;
              count++;
              buffer = buffer + hiker.toString(); //concatenates hikers to a String buffer.  
            }
          }
        }
        
        random_hikers -= count; //calculates total number of hikers left
        if(random_hikers >= 0){
          textArea.appendText("\nLetting " + count + " Hikers go up the mountain on entrance " + (mark + 1) + 
                              "\nThere are " + random_hikers +  " spots left for the day.\n");
        }
        if(queue[mark].isEmpty())
          mark++;
        
        //if(count == 20) 
        count = 0;
        
        if(random_hikers <= 0){
          openTrial.setDisable(true);
          closeTrials.setDisable(false);
        }     
        
      } catch (FileNotFoundException e1) {
        e1.printStackTrace();
        
      } catch(IOException e1){
        e1.printStackTrace();
        
      } finally{
        writer.println(buffer);
        writer.close();
      }
    });
    
    /*------------CLOSE TRIALS--------------*/
    closeTrials.setOnAction(e->{
      textArea.appendText("\n---Closing Trials---\n");
      
      closeTrials.setDisable(true);
      start.setDisable(false);
      
      PrintWriter writer = null;
      String file_in = "signIN.txt";
      String file_out = "signOUT.txt";
      String lines_read;
      BufferedReader bufReader;
      try{
        bufReader = new BufferedReader(new FileReader(file_in));
        writer = new PrintWriter(file_out);
        
        while((lines_read = bufReader.readLine()) != null){
          
          writer.println(lines_read);
        }
      }
      catch(FileNotFoundException e1){
        e1.printStackTrace();
      }
      catch(IOException e1){
        e1.printStackTrace();
      }
      finally{
        writer.close();
      }
      
      for(int i = 0; i < hikerCount.length; i++){
        textArea.appendText("\nNumber of hikers in entrance (" + (i+1) + ") : " + hikerCount[i] + " Hikers");
      }
      
      //resets the variables for another run
      for(int z = 0; z < hikerCount.length; z++){
        hikerCount[z] = 0;
      }
      index = 0;
      random_hikers = 0;
      total_hikers = 1;
      buffer = "";
      count = 0;
      mark = 0;
      
      
    });
    
    //adds CSS style to each button
    start.getStyleClass().add("button-green");
    openTrial.getStyleClass().add("button-yellow");
    closeTrials.getStyleClass().add("button-red");
    
    
    VBox root = new VBox();
    root.getChildren().addAll(textArea, start, openTrial, closeTrials); //adds the buttons to the root
    
    Scene scene = new Scene(root, 400, 300); //creates a scene and adds the root
    
    scene.getStylesheets().add("flux.css");
    primaryStage.setTitle("Purple Mountain");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
  //creates stacks 
  private static void creatStack(){
    if(index == stack.length)
      throw new ArrayIndexOutOfBoundsException("Can't create more stacks of Hikers for the day");
    else
      stack[index] = new Stackk(10);
  }
}