package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;
import model.Vehicle;
import view.tm.InParkingTm;
import view.tm.OnDeliveryTm;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static controller.AddDriverController.driverArrayList;
import static controller.AddVehicleController.vehicleArrayList;
import static controller.OnDeliveryController.onDeliveryVehiclesTMObservableList;
import static controller.ParkVehicleController.parkedVehiclesTMObservableList;

public class MainViewController{
    public AnchorPane mainViewContext;
    public ComboBox <String> cmbSelectVehicle;
    public ComboBox <String> cmbSelectDriver;
    public JFXTextField vehicleType;
    public TextField txtDate;
    public TextField txtTime;
    public JFXButton btnDelivery;
    public JFXButton btnPark;
    public Label slotNo;
    private int minute;
    private int hour;
    public int second;


    public void initialize(){
        for (Vehicle temp : vehicleArrayList) {
            cmbSelectVehicle.getItems().add(temp.getVehicleNo());
        }

        cmbSelectVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            cmbSelectVehicle.setAccessibleText(newValue);
            for (Vehicle temp : vehicleArrayList) {
                if (newValue.equals(temp.getVehicleNo())) {
                    vehicleType.setText(temp.getVehicleType());
                    disableAndEnable(cmbSelectVehicle.getValue().toString());
                    if(!btnPark.isDisable()){
                        try {
                            slotNo.setText(temp.park(temp.getVehicleNo(), temp.getVehicleType()) + "");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        for (Driver d : driverArrayList) {
            cmbSelectDriver.getItems().add(d.getName());
        }


        Thread clock = new Thread() {
            public void run() {
                for (; ; ) {
                    DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
                    Calendar cal = Calendar.getInstance();

                    second = cal.get(Calendar.SECOND);
                    minute = cal.get(Calendar.MINUTE);
                    hour = cal.get(Calendar.HOUR_OF_DAY);

                try {
                    String state = null;
                    if (hour >= 12) {
                        state = "PM";
                    } else {
                        state = "AM";
                    }
                    txtTime. setText("    " + String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second) + " " + state);

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                    }catch (NullPointerException e){
                        System.out.println(e);
                    }
                }
            }
        };
        clock.start();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        txtDate.setText(dateFormat.format(date));

    }

    public void disableAndEnable(String vehicleNo){
        btnPark.setDisable(false);
        btnDelivery.setDisable(false);
        for (InParkingTm temp:parkedVehiclesTMObservableList) {
            if(temp.getVehicleNo().equals(vehicleNo)){
                btnPark.setDisable(true);
            }
        }
        if(!btnPark.isDisable()){
            btnDelivery.setDisable(true);
        }
    }

    public void loadManagement(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/ManagementLogin.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void goToDelivery(ActionEvent actionEvent){
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            parkedVehiclesTMObservableList.removeIf(temp -> temp.getVehicleNo().equals(cmbSelectVehicle.getValue().toString()));
            OnDeliveryTm onDeliveryVehicleTM = new OnDeliveryTm(cmbSelectVehicle.getValue().toString(),vehicleType.getText(),cmbSelectDriver.getValue().toString(),java.time.LocalDateTime.now().format(dateTimeFormatter));
            onDeliveryVehiclesTMObservableList.add(onDeliveryVehicleTM);
        }catch (NullPointerException e){

        }
    }

    public void goToPark(ActionEvent actionEvent) {
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            InParkingTm parkedVehicleTM = new InParkingTm(cmbSelectVehicle.getValue().toString(),vehicleType.getText(), Integer.parseInt(slotNo.getText()),java.time.LocalDateTime.now().format(dateTimeFormatter));
            parkedVehiclesTMObservableList.add(parkedVehicleTM);

        }catch (NullPointerException e){

        }
    }

    public void pageRefresh(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MainView.fxml");
        Parent load = FXMLLoader.load(resource);
        mainViewContext.getChildren().clear();
        mainViewContext.getChildren().add(load);

    }

    public static class ExampleDate {
        public static void main(String[] args) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date date = new Date();
            System.out.println(formatter.format(date));
        }
    }
}
