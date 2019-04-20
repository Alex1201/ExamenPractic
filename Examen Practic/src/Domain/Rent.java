package Domain;

import java.util.Objects;

public class Rent extends Entity{

    private String id;
    private String carId;
    private double kmRun;
    private double daysNr;

    public Rent(String id, String carId, double daysNr, double kmRun) {
        super(id);
        this.carId = carId;
        this.daysNr = daysNr;
        this.kmRun = kmRun;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public double getDaysNr() {
        return daysNr;
    }

    public void setDaysNr(double daysNr) {
        this.daysNr = daysNr;
    }

    public double getKmRun() {
        return kmRun;
    }

    public void setKmRun(double kmRun) {
        this.kmRun = kmRun;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Rent rent = (Rent) o;
//        return Double.compare(rent.daysNr, daysNr) == 0 &&
//                Double.compare(rent.kmRun, kmRun) == 0 &&
//                carId.equals(rent.carId);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carId, daysNr, kmRun);
    }

}
