package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagementLoginController {
    public JFXTextField txtName;
    public JFXPasswordField txtPassword;
    public AnchorPane managementViewContext;
    public JFXButton btnCancel;
    public JFXButton btnLogIn;
    public Label label;

    public void cancelDetail(ActionEvent actionEvent){
        txtName.clear();
        txtPassword.clear();
        Stage stage =(Stage) managementViewContext.getScene().getWindow();
        stage.close();
    }

    public void logSystem(ActionEvent actionEvent) throws IOException {
        if(txtPassword.getText().equals("1234") & txtName.getText().equalsIgnoreCase("Yasiru")){
            URL resource = getClass().getResource("../view/DetailPage.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) managementViewContext.getScene().getWindow();
            window.setScene(new Scene(load));
        }
        else{
            label.setText("Enter Correct Username or Password");
        }
    }
}
