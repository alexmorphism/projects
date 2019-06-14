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

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;


// creates a class
public class Main extends Application {
	private String message = "";
	private Alphabet alpha = new Alphabet();
	
	@Override
	public void start(Stage primaryStage) { 		// overrides the start method
		Stage window = primaryStage;
		
		Text text = new Text();						// Creates a text
		text.setFont(new Font(40));
		//text.setX(200); text.setY(50);
		text.setText("RSA ENCRYPTION");
		
		TextArea tArea = new TextArea();			// creates a text area
		tArea.setWrapText(true);
		
		Button encrypt = new Button("Encrypt");		// creates buttons 
		Button decrypt = new Button("Decrypt");
		Button clear   = new Button("Clear");
		
		//encrypt button action
		encrypt.setOnAction(e-> {
			message = tArea.getText();
			List<String> processedText = new ArrayList<String>();
			try{
				alpha.writeFile(message);
				processedText = alpha.readLines("message.txt");
				tArea.appendText("\n\nEncrypting message...\n");
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
			tArea.clear();
			message = "";
		});
		
		VBox vbox = new VBox(text, tArea, encrypt, decrypt, clear); // vertical box group
		Group root = new Group(vbox); 			 	// creates a group object
		Scene scene1 = new Scene(root, 800, 600); 	// creates a scene
		window.setTitle("RSA Encryption"); 			// sets the title to the scene
		window.setScene(scene1); 					// add the scene to the stage
		window.show(); 								// displays the contents of the scene
		
	}

	public static void main(String[] args) {		// launch the application
		launch(args);
	}

}
