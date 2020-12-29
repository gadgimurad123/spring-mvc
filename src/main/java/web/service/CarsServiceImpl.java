package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarsServiceImpl implements CarsService {
    List<Car> carsList = new ArrayList<>();

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
}
