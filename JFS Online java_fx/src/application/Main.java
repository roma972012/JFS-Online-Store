package application;
	
import java.sql.Connection;
import java.sql.DriverManager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;// to get input for the username and for the password//
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;	//content inside the window//
import javafx.scene.control.Button;		//to set up the buttons//

 //SETTING UP THE PADDING TO THE USERNAME AND PASSWORD SIZE//

									//creating to build a event once click the button//
public class Main extends Application {
	
	
	public static void main(String[] args)throws Exception {
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	Parent root = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));	
	Scene scene = new Scene(root);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setTitle("JFS FISHING STACK");
	primaryStage.setScene(scene);
	primaryStage.show();

	

	
	
	}
}