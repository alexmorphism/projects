/*
 * GUI of the RSA Encryption project
 * 
 * Authors: Alexandre Castro and Samuel Gomez
 * Started on June 06 2019 (Summer 19) at University of Massachusetts Lowell
 */

package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.Group;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;


// creates a class
public class Main extends Application {
	Stage window;
	Scene scene1, scene2;
	private Alphabet alpha = new Alphabet();
	
	private FileChooser fileChooser;
	private File selectedFile;
	private FileIO reader;
	
	// initializes a public key
	private BigInteger np = new BigInteger("0");
	private BigInteger ep = new BigInteger("0");
	private Key publicKey = new Key(np, ep);
	
	// initializes a private key
	private BigInteger nr = new BigInteger("0");
	private BigInteger dr = new BigInteger("0");
	private Key privateKey = new Key(nr, dr);
	
	
	// launch the application
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		Label  label1    = new Label("Welcome to RSA encryption :)");
		Button genKey  	 = new Button("Genereate Key");
		Button contConvo = new Button("Continue Conversation");
		
		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		fileChooser.setTitle("upload your key");
		reader = new FileIO();
		
		
		genKey.setOnAction(e->{
			KeyGenerator keyGen = new KeyGenerator(16, 1024);
			System.out.println("Key generated!");
			//System.out.println(keyGen.toString());
		});
		
		contConvo.setOnAction(e->{
			window.setScene(scene2);
		});
		
		VBox layout1 = new VBox(30); 									
		layout1.getChildren().addAll(label1, genKey, contConvo);
		scene1 = new Scene(layout1, 800, 600);
		
		Button back        = new Button("Back");
		Button uploadText  = new Button("Upload Text");
		Button encode 	   = new Button("Encode");		 
		Button decode 	   = new Button("Decode");
		Button saveFile    = new Button("Save txt file");
		
		// UPLOADS TEXT
		uploadText.setOnAction(e->{
			
		});
		

		
		TextArea box1 = new TextArea();
		box1.setWrapText(true);
		
		TextArea box2 = new TextArea();
		box2.setWrapText(true);
		
		back.setOnAction(e->{ 
			window.setScene(scene1);
		});
		
		// ENCODE the message
		encode.setOnAction(e->{
			
		});
		
		// DECODE the message
		decode.setOnAction(e->{
			
		});
		BorderPane border = new BorderPane();
		scene2 = new Scene(border, 800, 600);
		HBox top = new HBox();
		top.getChildren().addAll(back, uploadText);
		border.setTop(top);
		
		VBox center = new VBox(10);
		center.getChildren().addAll(box1, box2);
		border.setCenter(center);
		
		VBox right = new VBox();
		right.getChildren().addAll(encode, decode);
		border.setRight(right);
		
		HBox bot = new HBox();
		bot.getChildren().addAll(saveFile);
		border.setBottom(bot);
		
		
		window.setTitle("RSA Encryption"); 							// sets the title to the scene
		window.setScene(scene1); 									// add the scene to the stage
		window.show(); 												// displays the contents of the scene
	}
	
	
	private void uploadKey(Key thekey) throws Exception
	{
		String str1 = "";
		String str2 = "";
		List<String> list = new ArrayList<String>();
		selectedFile = fileChooser.showOpenDialog(window);
		if(selectedFile != null){
			try{
				list = reader.readKey(selectedFile);
				str1 = list.get(0);
				str2 = list.get(1);
				BigInteger x = new BigInteger(str1);
				BigInteger y = new BigInteger(str2);
				thekey.setX(x);
				thekey.setY(y);
			} catch(FileNotFoundException ex){
				System.out.println(ex.getMessage());
			}
		}
	}
	
	private String getMessage(TextArea textarea){
		String message = textarea.getText();
		return message;
	}

}