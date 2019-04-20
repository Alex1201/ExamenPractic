package Domain;

import java.util.Objects;

public class Car extends Entity{

    protected static double getPrice;
    private String id, model;
    private double km,price;

    public Car(String id, String model, double km, double price) {
        super(id);
        this.model = model;
        this.km = km;
        this.price = price;
    }

    public Car() {

    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 &&
                Double.compare(car.km, km) == 0 &&
                model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), model, price, km);
    }

}
