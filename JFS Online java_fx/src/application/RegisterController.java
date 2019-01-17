package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class RegisterController {

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSubmit;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtnumber;

    @FXML
    void cancelAction(ActionEvent event) throws IOException {
    	btnCancel.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));	
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("JFS Fishing Shack");
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    @FXML
    void submitAction(ActionEvent event) throws SQLException, IOException {
    	
    	boolean isPassValid = isValid(txtPassword.getText());
    	
    	if(isPassValid) {
    		
    		if(txtname.getText().isEmpty() || txtEmail.getText().isEmpty() || txtnumber.getText().isEmpty() || txtPassword.getText().isEmpty()) {
        		
        		Alert alert = new Alert(Alert.AlertType.ERROR);
            	alert.setTitle("Registration Error");
            	alert.setHeaderText(null);
            	alert.setContentText("Please Fill In The Blanks ");
            	alert.showAndWait();	
        	
        	}else {
        		/*Pattern p = Pattern.compile("((?=.*\\\\d)(?=.*[a-z](?=.*[A-Z]) (?=.*[@#$%]).{8,15}))");
    	    	Matcher m = p.matcher(txtPassword.getText());
    	    	if(m.matches()) {*/
        	
        	Connectivity cnt = new Connectivity();
        	Connection connection =cnt.getConnection();
        	
        	String sql ="INSERT INTO reg(fullName,email,phone,password) VALUES('"+txtname.getText()+"','"
        	+txtEmail.getText()+"','"+txtnumber.getText()+"','"+txtPassword.getText()+"')";
        	
        	Statement statement = connection.createStatement();
        	statement.executeUpdate(sql);
        	
        	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	alert.setTitle("Registation Success");
        	alert.setHeaderText(null);
        	alert.setContentText("You Have Successfully Registered ");
        	alert.showAndWait();
        	
    	    	/*}else {
    	    		Alert alert = new Alert(Alert.AlertType.WARNING);
    	    		alert.setTitle("validate Password");
    	    		alert.setHeaderText(null);
    	    		alert.setContentText("Enter a valid ");
    	    		alert.showAndWait();*/
    			btnSubmit.getScene().getWindow().hide();
    			Stage primaryStage = new Stage();
    			Parent root = FXMLLoader.load(getClass().getResource("/application/login.fxml"));
    			Scene scene = new Scene(root);
    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    			primaryStage.setTitle("Login");
    			primaryStage.setScene(scene);
    			primaryStage.show();
    		}

    		
    	}else {
    		System.out.println("validation failed");
    		Alert alert = new Alert(Alert.AlertType.ERROR);
        	alert.setTitle("Registration Error");
        	alert.setHeaderText(null);
        	alert.setContentText("Please Enter a valid password ");
        	alert.showAndWait();	
    	}
    	
    	
	}

    	
    	
    

    





	    
	  
	   
		/*	Pattern p = Pattern.compile("(?=.*\\d)(?=.*[a-z] (?=.*[@#$%]).{8,}");
	    	Matcher m = p.matcher(txtRegisterPassword.getText());
	    	if(m.matches()) {
	    		System.out.println("Login Succesfull");
	    	}else {
	    		Alert alert new Alert(Alert.AlertType.WARNING);
	    		alert.setTitle("validate Password");
	    		alert.setContentText("uhbhbuh");
	    		alert.showAndWait();
	    		System.out.println("Log In Successful");
	    	}*/
	    	
	    
	  
	   
	    	
	    	
public static boolean isValid(String password) {

    
    String validPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    boolean b=true;

    if (!password.matches(validPassword)) {
        System.err.println("password validation failed! ");
        b=false;
    }
    
    return b;
}

}
	 
	


																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																	
