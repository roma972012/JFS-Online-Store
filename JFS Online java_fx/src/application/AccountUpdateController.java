package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountUpdateController {

	@FXML
	private Button btnCancel2;

	@FXML
	private Button btnUpdate2;

	@FXML
	private TextField txtEmail;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private TextField txtname;

	@FXML
	private TextField txtnumber;

	@FXML
	void cancelAction2(ActionEvent event) throws IOException {
		btnCancel2.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/OnlineStore.fxml"));	
		Scene scene = new Scene(root);
		primaryStage.setTitle("JFS Fishing Shack");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	@FXML
	void update(ActionEvent event) throws SQLException, IOException {
		if (txtname.getText().isEmpty() || txtEmail.getText().isEmpty() || txtnumber.getText().isEmpty()
				|| txtPassword.getText().isEmpty()) {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Registration Error");
			alert.setHeaderText(null);
			alert.setContentText("Please Fill In The Blanks ");
			alert.showAndWait();

		} else {

			Connectivity cnt = new Connectivity();
			Connection connection = cnt.getConnection();

			String sql = "UPDATE reg SET fullName = '" + txtname.getText() + "',phone = '" + txtnumber.getText() + 
					"',password = '" + txtPassword.getText() + "'where email='" +txtEmail.getText() +"'";

			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			
			txtname.setText(null);
			txtnumber.setText(null);
			txtPassword.setText(null);

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Update Success");
			alert.setHeaderText(null);
			alert.setContentText("You Have Successfully Updated ");
			alert.showAndWait();
			
			btnUpdate2.getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));	
			Scene scene = new Scene(root);
			primaryStage.setTitle("Login");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		}

	}

}
/*(fullName,email,phone,password) VALUES('" + txtname.getText() + "','"
		+ txtEmail.getText() + "','" + txtnumber.getText() + "','" + txtPassword.getText() + "')";*/
