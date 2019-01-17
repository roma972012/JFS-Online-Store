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
import javafx.scene.control.*;
import javafx.stage.Stage;

public class InvoiceController implements Initializable{
	
	public static String invoice;
    @FXML
    private TextArea txtAreaInvoice;

    @FXML
    private Button btnBack;

    @FXML
    void goBackAction(ActionEvent event) throws IOException{
    	
    	btnBack.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/OnlineStore.fxml"));	
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Online Store");
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		txtAreaInvoice.setText(invoice);
	}

}
