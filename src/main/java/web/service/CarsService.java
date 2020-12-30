package web.service;

import web.model.Car;

import java.util.List;

public interface CarsService {
    List<Car> getListOfCars();

    List<Car> getSubListOfCars(int carsCount);
}
