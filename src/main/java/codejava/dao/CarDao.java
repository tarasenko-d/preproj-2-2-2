package codejava.dao;

import codejava.model.Car;

import java.util.List;

public interface CarDao {

    void add(Car car);

    List<Car> listCars(int counter);

}
