package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class OnlineStoreController {

	@FXML
    private TextField itemFL;

    @FXML
    private TextField itemSI;

    @FXML
    private TextField itemSW;

    @FXML
    private TextField flTotalPrice;

    @FXML
    private TextField siTotalPrice;

    @FXML
    private TextField swTotalPrice;

    @FXML
    private TextField flQuantity;

    @FXML
    private TextField slQuantity;

    @FXML
    private TextField txtAreaInvoice;

    @FXML
    private Button btnCalculateTotal;

    @FXML
    private TextField calculateTotal;

    @FXML
    private Button btnOrder;
    
    @FXML
    private Button btnOrder2;
    
    @FXML
    private Button btnOrder3;
    
    @FXML
    private RadioButton flPrice5;

    @FXML
    private ToggleGroup flToggleGroup;

    @FXML
    private RadioButton flPrice10;

    @FXML
    private RadioButton flPrice20;

    @FXML
    private RadioButton siPrice10;

    @FXML
    private ToggleGroup siToggleGroup;

    @FXML
    private RadioButton siPrice20;

    @FXML
    private RadioButton siPrice30;

    @FXML
    private RadioButton swPrice3;

    @FXML
    private ToggleGroup swToggleGroup;

    @FXML
    private RadioButton swPrice6;

    @FXML
    private RadioButton swPrice10;

    @FXML
    private Button btnUpdate;

    @FXML
    private Label codeFL;

    @FXML
    private Label codeSI;

    @FXML
    private Label codeSW;

    @FXML
    private Button btnLogout;
    
    @FXML
    private TextField swQuantity;
    
    private int flAmount;
    private int siAmount;
    private int swAmount;
    
    @FXML
    void logout(ActionEvent event) throws IOException {
    	btnLogout.getScene().getWindow().hide();
    	Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));	
		Scene scene = new Scene(root);
		primaryStage.setTitle("JFS FISHING STACK");
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    
    @FXML
    void updatePage(ActionEvent event) throws IOException {
    	btnUpdate.getScene().getWindow().hide();
    	Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/AccountUpdate.fxml"));	
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Change Account Details");
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    @FXML
    void orderAction(ActionEvent event) throws IOException {
    	if (flQuantity.getText().isEmpty() || getFLPrice().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter the size and the quantity");
            alert.showAndWait();
        } else {
        	int qty = Integer.parseInt(flQuantity.getText());
        	double total = qty * flAmount;
        	String sTotal = String.valueOf(total);
        	flTotalPrice.setText(sTotal);
        	InvoiceCreationClass.productName = itemFL.getText();
        	InvoiceCreationClass.productSize = getFLPrice();
        	InvoiceCreationClass.productCode = codeFL.getText();
        	InvoiceCreationClass.productQty = flQuantity.getText();
        	InvoiceCreationClass.productAmount = sTotal;
        	String invoice = InvoiceCreationClass.invoiceDetails();
        	InvoiceController.invoice = invoice; 
        	
        	btnOrder.getScene().getWindow().hide();
        	Stage primaryStage = new Stage();
    		Parent root = FXMLLoader.load(getClass().getResource("/application/Invoice.fxml"));	
    		Scene scene = new Scene(root);
    		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		primaryStage.setTitle("Invoice");
    		primaryStage.setScene(scene);
    		primaryStage.show();
        }
    }
    
    @FXML
    void orderAction2(ActionEvent event) throws IOException {
    	if (slQuantity.getText().isEmpty() || getSIPrice().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter the size and the quantity");
            alert.showAndWait();
        } else {
        	int qty = Integer.parseInt(slQuantity.getText());
        	double total = qty * siAmount;
        	String sTotal = String.valueOf(total);
        	siTotalPrice.setText(sTotal);
        	InvoiceCreationClass.productName = itemSI.getText();
        	InvoiceCreationClass.productSize = getSIPrice();
        	InvoiceCreationClass.productCode = codeSI.getText();
        	InvoiceCreationClass.productQty = slQuantity.getText();
        	InvoiceCreationClass.productAmount = sTotal;
        	String invoice = InvoiceCreationClass.invoiceDetails();
        	InvoiceController.invoice = invoice; 
        	
        	btnOrder.getScene().getWindow().hide();
        	Stage primaryStage = new Stage();
    		Parent root = FXMLLoader.load(getClass().getResource("/application/Invoice.fxml"));	
    		Scene scene = new Scene(root);
    		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		primaryStage.setTitle("Invoice");
    		primaryStage.setScene(scene);
    		primaryStage.show();
        }
    }
    
    @FXML
    void orderAction3(ActionEvent event) throws IOException {
    	if (swQuantity.getText().isEmpty() || getSWPrice().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter the size and the quantity");
            alert.showAndWait();
        } else {
        	int qty = Integer.parseInt(swQuantity.getText());
        	double total = qty * swAmount;
        	String sTotal = String.valueOf(total);
        	swTotalPrice.setText(sTotal);
        	InvoiceCreationClass.productName = itemSW.getText();
        	InvoiceCreationClass.productSize = getSWPrice();
        	InvoiceCreationClass.productCode = codeSW.getText();
        	InvoiceCreationClass.productQty = swQuantity.getText();
        	InvoiceCreationClass.productAmount = sTotal;
        	String invoice = InvoiceCreationClass.invoiceDetails();
        	InvoiceController.invoice = invoice; 
        	
        	btnOrder.getScene().getWindow().hide();
        	Stage primaryStage = new Stage();
    		Parent root = FXMLLoader.load(getClass().getResource("/application/Invoice.fxml"));	
    		Scene scene = new Scene(root);
    		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		primaryStage.setTitle("Invoice");
    		primaryStage.setScene(scene);
    		primaryStage.show();
        }
    }
    
    private String getFLPrice() {
        String price = "";
        if (flPrice5.isSelected()) {
        	flAmount = 5;
            price = "5";
        } else if (flPrice10.isSelected()) {
        	flAmount = 10;
            price = "10";
        } else if (flPrice20.isSelected()) {
        	flAmount =20;
            price = "20";
        }
        return price;
    }
    
    private String getSIPrice() {
        String price = "";
        if (siPrice10.isSelected()) {
        	siAmount = 10;
            price = "10";
        } else if (siPrice20.isSelected()) {
        	siAmount = 20;
        	price = "20";
        } else if (siPrice30.isSelected()) {
        	siAmount = 30;
        	price = "30";
        }
        return price;
    }
    
    private String getSWPrice() {
        String price = "";
        if (swPrice10.isSelected()) {
        	swAmount = 10;
            price = "10";
        } else if (swPrice3.isSelected()) {
        	swAmount = 3;
            price = "3";
        } else if (swPrice6.isSelected()) {
        	swAmount = 6;
            price = "6";
        }
        return price;
    }
    
    @FXML
    private void calculateAction(ActionEvent event){
    
    }
    

}