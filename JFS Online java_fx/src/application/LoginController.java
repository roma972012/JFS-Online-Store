package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtusername;

    @FXML
    private Button btnBackButton;
    
    @FXML
    private Label lblstatus;

    @FXML
    void goBack(ActionEvent event) throws IOException {
    	btnLogin.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));	
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("JFS Fishing Shack");
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    @FXML
    void login(ActionEvent event)throws SQLException, IOException {
    	Connectivity cnt = new Connectivity();
    	Connection connection =cnt.getConnection();
    	Statement statement = connection.createStatement();
    	String sql = "SELECT Email,Password FROM reg WHERE Email = ('"+txtusername.getText()+"') && Password = ('"+txtpassword.getText()+"')"; 
    	ResultSet resultSet = statement.executeQuery(sql);
    	int count = 0;
    	while (resultSet.next()) {
    		count = count+1;
    	}
    	if(count == 1) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("Login Successfull");
    		alert.setHeaderText(null);
    		lblstatus.setText("Login Succesfull");
    		alert.showAndWait();
    	//	System.out.println("Login Success");
    		
    		btnLogin.getScene().getWindow().hide();
    		Stage primaryStage = new Stage();
    		Parent root = FXMLLoader.load(getClass().getResource("/application/OnlineStore.fxml"));	
    		Scene scene = new Scene(root);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		primaryStage.setTitle("Online Store");
    		primaryStage.setScene(scene);
    		primaryStage.show();
    		
    	}else {
    		
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle("Login Failed");
    		alert.setHeaderText(null);
    		lblstatus.setText("Login Failed");
    		alert.showAndWait();
    		
    	}
    }

}
