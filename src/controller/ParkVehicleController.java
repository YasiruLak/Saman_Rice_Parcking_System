package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import view.tm.InParkingTm;

public class ParkVehicleController {
    public AnchorPane contextInParking;
    public TableView tblInParking;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;



    public static ObservableList<InParkingTm> parkedVehiclesTMObservableList = FXCollections.observableArrayList();

    public void initialize(){
        tblInParking.setItems(parkedVehiclesTMObservableList);
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory<>("parkingSlot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory<>("parkedTime"));
}
}
