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
		
		Button back      = new Button("Back");
		Button uploadPr  = new Button("Upload Private");
		Button uploadPu  = new Button("Upload Public");
		Button encrypt 	 = new Button("Encrypt");		 
		Button decrypt 	 = new Button("Decrypt");
		Button clear   	 = new Button("Clear");
		
		// UPLOADS PRIVATE KEY
		uploadPr.setOnAction(e->{
			try {
				uploadKey(privateKey);
				System.out.println(privateKey.toString());
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		});
		
		// UPLOADS PUBLIC KEY
		uploadPu.setOnAction(e->{
			try{
				uploadKey(publicKey);
				System.out.println(publicKey.toString());
			} catch(Exception e1){
				System.out.println(e1.getMessage());
			}
		});
		

		
		TextArea box1 = new TextArea();
		box1.setWrapText(true);
		
		TextArea box2 = new TextArea();
		box2.setWrapText(true);
		
		back.setOnAction(e->{ 
			window.setScene(scene1);
		});
		
		// ENCRYPT the message
		encrypt.setOnAction(e->{
			//encrypt do something
			
		});
		
		HBox layout2 = new HBox();
		layout2.getChildren().addAll(back, uploadPr, uploadPu);
		
		HBox layout3 = new HBox();
		layout3.getChildren().addAll(encrypt, decrypt);
		
		VBox layout4 = new VBox(20);
		layout4.getChildren().addAll(layout2, box1, layout3, box2);
		
		
		scene2 = new Scene(layout4, 800, 600);
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