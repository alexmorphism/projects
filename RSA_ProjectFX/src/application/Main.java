/*
 * GUI of the RSA Encryption project
 * Authors
 * Samuel Gomez and Alexandre Castro
 * Started on June 06 2019 (Summer 19) at UML
 */

package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
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
	
	private String message = "";
	private Alphabet alpha = new Alphabet();
	
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
		
		contConvo.setOnAction(e->{
			window.setScene(scene2);
		});
		
		
		VBox layout1 = new VBox(30); 									
		layout1.getChildren().addAll(label1,genKey, contConvo);
		scene1 = new Scene(layout1, 800, 600);
		
		
		Button back      = new Button("Back");
		Button uploadPr  = new Button("Upload Private");
		Button uploadPu  = new Button("Upload Public");
		Button encrypt 	 = new Button("Encrypt");		 
		Button decrypt 	 = new Button("Decrypt");
		Button clear   	 = new Button("Clear");
		
		TextArea box1 = new TextArea();
		box1.setWrapText(true);
		
		TextArea box2 = new TextArea();
		box2.setWrapText(true);
		
		back.setOnAction(e->{ 
			window.setScene(scene1);
		});
		
		HBox layout2 = new HBox();
		layout2.getChildren().addAll(back, uploadPr, uploadPu);
		//layout2.setPadding(new Insets(5,10,5,10));
		
		HBox layout3 = new HBox();
		layout3.getChildren().addAll(encrypt, decrypt);
		
		VBox layout4 = new VBox(20);
		layout4.getChildren().addAll(layout2, box1, layout3, box2);
		
		
		
		scene2 = new Scene(layout4, 800, 600);
		
		window.setTitle("RSA Encryption"); 							// sets the title to the scene
		window.setScene(scene1); 									// add the scene to the stage
		window.show(); 												// displays the contents of the scene
	}

}
/*

//encrypt button action
encrypt.setOnAction(e-> {
	//message = tArea.getText();
	List<String> processedText = new ArrayList<String>();
	try{
		alpha.writeFile(message);
		processedText = alpha.readLines("message.txt");
		//tArea.appendText("\n\nEncrypting message...\n");
	} catch(Exception ex){
		System.out.println(ex);
	}
	
	for(String s: processedText)
		System.out.println(s);
});

//decrypt button action
decrypt.setOnAction(e->{
	
});

//clear button action
clear.setOnAction(e->{
	//tArea.clear();
	message = "";
});
*/
