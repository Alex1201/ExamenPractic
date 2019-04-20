package UI;

import Domain.Car;
import Domain.Rent;
import Service.CarService;
import Service.RentService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

public class Controller {

    public TableView tableViewCars;
    public TableColumn CarID;
    public TableColumn CarModel;
    public TableColumn CarKm;
    public TableColumn CarPrice;
    public TextField carId;
    public TextField carModel;
    public TextField carKm;
    public TextField carPrice;
    public TextField searchKmCar;
    public Button AddCar;

    public TableView tableViewRents;
    public TableColumn RentID;
    public TableColumn RentIdCar;
    public TableColumn RentDaysNr;
    public TableColumn RentKm;
    public TextField rentId;
    public TextField rentIdCar;
    public TextField rentDaysNr;
    public TextField rentKm;
    public TextField searchIncome;
    public Button AddRent;

    private CarService carService;
    private RentService rentService;

    private ObservableList<Car> cars = FXCollections.observableArrayList();
    private ObservableList<Rent> rents = FXCollections.observableArrayList();

    public void AddCar(ActionEvent actionEvent) {
        try {
            String id = carId.getText();
            String model = carModel.getText();
            String km = carKm.getText();
            String price = carPrice.getText();
            carService.add(id,model,km,price);

            carId.clear();
            carModel.clear();
            carKm.clear();
            carPrice.clear();

            cars.clear();
            cars.addAll(carService.getAll());

        } catch (RuntimeException ex) {
            Common.showValidationError(ex.getMessage());
        }
    }

    public void setServices(CarService carService, RentService rentService) {
        this.carService = carService;
        this.rentService = rentService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            cars.addAll(carService.getAll());
            tableViewCars.setItems(cars);
        });

        Platform.runLater(() -> {
            rents.addAll(rentService.getAll());
            tableViewRents.setItems(rents);
        });
    }

    public void AddRent(ActionEvent actionEvent) {
        try {
            String id = rentId.getText();
            String carId = rentIdCar.getText();
            double daysNr = Double.parseDouble(rentDaysNr.getText());
            double km = Double.parseDouble(rentKm.getText());
            rentService.add(id,carId,daysNr,km);

            rentId.clear();
            rentIdCar.clear();
            rentDaysNr.clear();
            rentKm.clear();

            rents.clear();
            rents.addAll(rentService.getAll());

        } catch (RuntimeException ex) {
            Common.showValidationError(ex.getMessage());
        }
    }

//    public void KmReport (ActionEvent actionEvent) {
//
//        cars.clear();
//        List<Car> temp = carService.searchKm();
//        cars.addAll(temp);
//    }

//    public void incomeReport (ActionEvent actionEvent) {
//
//        rents.clear();
//        List<Rent> temp = (List<Rent>) rentService.searchIncome();
//        rents.addAll(temp);
//    }

    public void sort (ActionEvent actionEvent) {

        rents.clear();
        List<Rent> temp = rentService.sort();
        rents.addAll(temp);
    }
}
