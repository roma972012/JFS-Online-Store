package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomeController implements Initializable{

	@FXML
    private Button UserLogin;
	
	@FXML
	private Button Register;
	
	@FXML
	private Button btnMaintain;
	
	
	
	@FXML
	public void loginPage(ActionEvent event) throws IOException{
		
			UserLogin.getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));	
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Login");
			primaryStage.setScene(scene);
			primaryStage.show();
				
		}
	
	@FXML
	public void registerPage(ActionEvent event) throws IOException {
		
		Register.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Register.fxml"));	
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Register");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	@FXML
    void maintainPage(ActionEvent event) throws IOException {
		
		btnMaintain.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Maintain.fxml"));	
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Maintain");
		primaryStage.setScene(scene);
		primaryStage.show();
    }
	
	
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	
	
	
	
	
	
}
