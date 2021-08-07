package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Bus;
import model.CargoLorry;
import model.Van;
import model.Vehicle;

import java.util.ArrayList;

public class AddVehicleController {

    public TextField txtPassenger;
    public TextField txtWeight;
    public TextField txtNumber;
    public ComboBox cmbVehicle;
    public AnchorPane contextVehicle;
    public TableView tblVehicle;
    public TableColumn colVehicleNo;
    public TableColumn colVehicleType;
    public TableColumn colWeight;
    public TableColumn colPassenger;

    private String vehicleType;

    static ArrayList<Vehicle> vehicleArrayList = new ArrayList();

    public void initialize() {

        colVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colWeight.setCellValueFactory(new PropertyValueFactory<>("maxWeight"));
        colPassenger.setCellValueFactory(new PropertyValueFactory<>("noOfPassengers"));

        cmbVehicle.getItems().addAll("Van","Bus","Cargo Lorry");

    }

    public void saveVehicleOnAction(ActionEvent actionEvent) {

             try {

                 if (cmbVehicle.getSelectionModel().getSelectedItem().toString().equals("Van")) {
                     Van van = new Van(txtNumber.getText(), cmbVehicle.getValue().toString(), Integer.parseInt(txtPassenger.getText()), Integer.parseInt(txtWeight.getText()));
                     txtNumber.clear();
                     txtPassenger.clear();
                     txtWeight.clear();
                     if (vehicleArrayList.add(van)) {
                         loadAllVehicles();
                         cmbVehicle.getSelectionModel().clearSelection();
                         new Alert(Alert.AlertType.CONFIRMATION, "Saved successfully...", ButtonType.CLOSE).show();
                     } else {
                         new Alert(Alert.AlertType.WARNING, "Try Again...", ButtonType.CLOSE).show();
                     }

                 }

                 if (cmbVehicle.getSelectionModel().getSelectedItem().toString().equals("Bus")) {
                     Bus bus = new Bus(txtNumber.getText(), cmbVehicle.getValue().toString(), Integer.parseInt(txtPassenger.getText()), Integer.parseInt(txtWeight.getText()));
                     txtNumber.clear();
                     txtPassenger.clear();
                     txtWeight.clear();

                     if (vehicleArrayList.add(bus)) {
                         loadAllVehicles();
                         cmbVehicle.getSelectionModel().clearSelection();
                         new Alert(Alert.AlertType.CONFIRMATION, "Saved successfully...", ButtonType.CLOSE).show();
                     } else {
                         new Alert(Alert.AlertType.WARNING, "Try Again...", ButtonType.CLOSE).show();
                     }

                 }

                 if (cmbVehicle.getSelectionModel().getSelectedItem().toString().equals("Cargo Lorry")) {
                     CargoLorry cargoLorry = new CargoLorry(txtNumber.getText(), cmbVehicle.getValue().toString(), Integer.parseInt(txtPassenger.getText()), Integer.parseInt(txtWeight.getText()));
                     txtNumber.clear();
                     txtPassenger.clear();
                     txtWeight.clear();

                     if (vehicleArrayList.add(cargoLorry)) {
                         loadAllVehicles();
                         cmbVehicle.getSelectionModel().clearSelection();
                         new Alert(Alert.AlertType.CONFIRMATION, "Saved successfully...", ButtonType.CLOSE).show();
                     } else {
                         new Alert(Alert.AlertType.WARNING, "Try Again...", ButtonType.CLOSE).show();
                     }
                 }
             } catch (RuntimeException e) {

             }
         }

    private void loadAllVehicles(){
        ObservableList<Vehicle>observableList=FXCollections.observableArrayList();
        if (cmbVehicle.getSelectionModel().getSelectedItem().toString().equals("Cargo Lorry")){
            for (Vehicle t : vehicleArrayList){
                observableList.add(new CargoLorry(t.getVehicleNo(),t.getVehicleType(),t.getNoOfPassengers(),t.getMaxWeight()));
            }
            tblVehicle.setItems(observableList);
        }
        if (cmbVehicle.getSelectionModel().getSelectedItem().toString().equals("Van")){
            for (Vehicle t1 : vehicleArrayList){
                observableList.add(new Van(t1.getVehicleNo(),t1.getVehicleType(),t1.getNoOfPassengers(),t1.getMaxWeight()));
            }
            tblVehicle.setItems(observableList);
        }

            if (cmbVehicle.getSelectionModel().getSelectedItem().toString().equals("Bus")) {
                for (Vehicle t2 : vehicleArrayList) {
                    observableList.add(new Bus(t2.getVehicleNo(), t2.getVehicleType(), t2.getNoOfPassengers(), t2.getMaxWeight()));
                }
                tblVehicle.setItems(observableList);
            }
    }
}

