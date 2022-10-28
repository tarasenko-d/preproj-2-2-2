package codejava.controller;

import codejava.model.Car;
import codejava.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class CarController {

    private CarService carService;

    // будет ли спринг видеть конструктор (?)
    public CarController(CarService carService) {
        this.carService = carService;
        carService.add(new Car("Audi", "sand", 5673));
        carService.add(new Car("Porsh", "black", 8720));
        carService.add(new Car("Mazda", "white", 6922));
        carService.add(new Car("Mercedes", "white", 8720));
        carService.add(new Car("BMW", "blue", 7254));
    }

    @GetMapping("/cars")
    public ModelAndView cars(@RequestParam(value = "count", defaultValue = "4") int counter) {
        List<Car> carList = carService.listCars(counter);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("carList", carList);
        return modelAndView;
    }


   /* @RequestMapping("/cars")
    public ModelAndView home() {
        List<Car> carList = new ArrayList<>();
        carService.listCars();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("carList", carList);
        return mav;
    }*/
}
