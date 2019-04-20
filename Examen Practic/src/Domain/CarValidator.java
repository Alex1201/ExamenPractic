package Domain;

public class CarValidator implements IValidator<Car>{

    public void validate(Car A) {
        if(A.getPrice().equals(0)) throw new RuntimeException("Price must be positive!");
    }
}
