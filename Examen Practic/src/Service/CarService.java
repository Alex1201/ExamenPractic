package Service;

import Domain.Car;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarService {

    private IRepository<Car> repository;

    public CarService(IRepository<Car> repository) {
        this.repository = repository;
    }

    public void add(String id, String model, double km, double price) {
        Car temp = new Car(id, model, km, price);
        repository.upsert(temp);
    }

    public List<Car> searchKm(String id) {

        List<Car> temp = new ArrayList<>();
        for (Car t : repository.getAll()) {
            if (t.getId().contains(id))
                temp.add(t);
        }
        return temp;
    }

    public List<Car> getAll() {
        return repository.getAll();
    }
}
