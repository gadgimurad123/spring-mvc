package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarsService;

import java.util.List;

@Controller
public class CarsController {

    @Autowired
    private CarsService carsService;

    @GetMapping("/cars")
    public String carsPage(Model model, @RequestParam(defaultValue = "5") int param) {

        List<Car> carsList = carsService.getListOfCars();

        if (param < 0 || param > 5) {
            param = 5;
        }

        if (param < 5) {
            List<Car> carsSubList = carsService.getSubListOfCars(param);
            model.addAttribute("cars", carsSubList);
        } else {
            model.addAttribute("cars", carsList);
        }
        return "cars";
    }
}
