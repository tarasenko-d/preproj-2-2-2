package codejava.service;

import codejava.dao.CarDao;
import codejava.model.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements codejava.service.CarService {

    private final CarDao carDao;

    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    @Transactional
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Car> listCars(int counter) {
        return carDao.listCars(counter);
    }

}
