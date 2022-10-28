package codejava.service;

import codejava.model.Car;

import java.util.List;

public interface CarService {

    void add(Car car);

    List<Car> listCars(int counter);


}
