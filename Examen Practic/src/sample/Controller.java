package sample;

import Domain.*;
import Repository.FileRepository;
import Repository.IRepository;
import Service.CarService;
import Service.RentService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller extends Application {

    @Override
    public void start(Stage newStage) throws Exception{

        IValidator<Car> carValidator = new CarValidator();
        IRepository<Car> carRepository= new FileRepository<>(carValidator, "cars.json", Car[].class);
        CarService carService = new CarService(carRepository);

        IValidator<Rent> rentValidator = new RentValidator();
        IRepository<Rent> rentRepository= new FileRepository<>(rentValidator, "rents.json", Rent[].class);
        RentService rentService = new RentService(rentRepository);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = fxmlLoader.load();
        UI.Controller mainController = fxmlLoader.getController();
        mainController.setServices(carService,rentService);
        newStage.setTitle("Service Auto");
        newStage.setScene(new Scene(root, 700, 700));
        newStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
