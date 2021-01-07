package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarsServiceImpl implements CarsService {
    private final List<Car> carsList = new ArrayList<>();

    {
        carsList.add(new Car("Car1", "123", 2001));
        carsList.add(new Car("Car2", "234", 2002));
        carsList.add(new Car("Car3", "345", 2003));
        carsList.add(new Car("Car4", "456", 2004));
        carsList.add(new Car("Car5", "567", 2005));
    }

    @Override
    public List<Car> getListOfCars() {
        return carsList;
    }

    @Override
    public List<Car> getSubListOfCars(int carsCount) {
        return new ArrayList<>(carsList.subList(0, carsCount));
    }
}
