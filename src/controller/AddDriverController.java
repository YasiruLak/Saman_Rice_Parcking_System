package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Driver;

import java.util.ArrayList;


public class AddDriverController {
    public TextField txtName;
    public TextField txtNIC;
    public TextField txtLicenseNo;
    public TextField txtAddress;
    public TextField txtContact;
    public TableView tblDriver;
    public TableColumn colName;
    public TableColumn colNIC;
    public TableColumn colLicenseNo;
    public TableColumn colAddress;
    public TableColumn colContact;

    static ArrayList<Driver> driverArrayList = new ArrayList();

    public void initialize(){
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colLicenseNo.setCellValueFactory(new PropertyValueFactory<>("licenseNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }

    public void addDriver(ActionEvent actionEvent) {
        Driver driver = new Driver(txtName.getText(),txtNIC.getText(),txtLicenseNo.getText(),txtAddress.getText(),Integer.parseInt(txtContact.getText()));

        txtName.clear();txtNIC.clear();txtLicenseNo.clear();txtAddress.clear();txtContact.clear();

        if (driverArrayList.add(driver)){
            loadAllDrivers();
            new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully...", ButtonType.CLOSE).show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again...", ButtonType.CLOSE).show();
        }
    }
    private void loadAllDrivers(){
        ObservableList<Driver> ObservableList = FXCollections.observableArrayList();
        for (Driver temp:driverArrayList
             ) {
            ObservableList.add(
                    new Driver(temp.getName(),temp.getNIC(),temp.getLicenseNo(),temp.getAddress(),temp.getContact())
            );
        }
        tblDriver.setItems(ObservableList);
    }
}
