package Service;

import Domain.Car;
import Domain.Rent;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RentService extends Car{

    private IRepository<Rent> repository;

    public RentService(IRepository<Rent> repository) {
        super();
        this.repository = repository;
    }

    public void add(String id, String carId, double daysNr, double kmRun) {
        Rent temp = new Rent(id, carId, daysNr, kmRun);
        repository.upsert(temp);
    }

    public List<Rent> searchIncome(double daysNr, String id) {

        List<Rent> temp = new ArrayList<>();
        double income = Car.getPrice * daysNr;
        for (Rent t : repository.getAll()) {
            if (t.getDaysNr() == daysNr)
                temp.add(t);
        }
        return temp;
    }

    public List<Rent> sort() {

        List<Rent> rents= new ArrayList<>(repository.getAll());
        Comparator<Rent> byDays = (d1 , d2) -> {
            int t1=0,t2=0;
            for(Rent t : repository.getAll()){
                if(t.getCarId().equals(d1.getCarId()))
                    t1 += t.getDaysNr();
                if(t.getCarId().equals(d2.getCarId()))
                    t2 += t.getDaysNr();
            }
            return t2-t1;
        };

        List<Rent> temp = new ArrayList<>(repository.getAll());
        temp.sort(byDays);
        return temp;
    }

    public List<Rent> getAll() {
        return repository.getAll();
    }
}

