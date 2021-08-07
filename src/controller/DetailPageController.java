package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DetailPageController {
    public AnchorPane detailPageContext;
    public AnchorPane windowContext;
    public JFXButton btnLogout;
    public ComboBox cmbDetailOption;


    public void initialize() {
        cmbDetailOption.getItems().addAll("In Parking", "On Delivery");

        cmbDetailOption.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue.equals("On Delivery")) {

                URL resource = getClass().getResource("../view/OnDelivery.fxml");
                Parent load = null;

                try {
                    load = FXMLLoader.load(resource);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                windowContext.getChildren().clear();
                windowContext.getChildren().add(load);

            }else if(newValue.equals("In Parking")){
                URL resource = getClass().getResource("../view/ParkVehicle.fxml");
                Parent load = null;

                try {
                    load = FXMLLoader.load(resource);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                windowContext.getChildren().clear();
                windowContext.getChildren().add(load);
            }
        });

    }

    public void loadDriver(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriver.fxml");
        Parent load = FXMLLoader.load(resource);
        windowContext.getChildren().clear();
        windowContext.getChildren().add(load);
    }

    public void loadVehicle(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicle.fxml");
        Parent load = FXMLLoader.load(resource);
        windowContext.getChildren().clear();
        windowContext.getChildren().add(load);
    }

    public void loadManagement(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = (Stage) detailPageContext.getScene().getWindow();
            stage.close();
        }catch (Exception e) {

        }

    }
}


