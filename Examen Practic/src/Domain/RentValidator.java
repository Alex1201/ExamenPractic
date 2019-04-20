package Domain;

public class RentValidator implements IValidator<Rent> {
    public void validate(Rent A) {
        if(A.getDaysNr() <= 0) throw new RuntimeException("Days number must be positive!");
    }
}
