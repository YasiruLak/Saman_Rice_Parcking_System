package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import view.tm.OnDeliveryTm;

public class OnDeliveryController {
    public AnchorPane contextOnDelivery;
    public TableView tblOnDelivery;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;

    public static ObservableList<OnDeliveryTm> onDeliveryVehiclesTMObservableList = FXCollections.observableArrayList();

    public void initialize(){
        tblOnDelivery.setItems(onDeliveryVehiclesTMObservableList);
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));

    }
}
