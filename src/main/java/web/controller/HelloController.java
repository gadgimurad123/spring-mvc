package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarsService;
import web.service.CarsServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/cars")
    public String carsPage(Model model, @RequestParam(defaultValue = "5") String param) {

        CarsService carsService = new CarsServiceImpl();
        List<Car> carsList = carsService.getListOfCars();

        int value = Integer.parseInt(param);

        if (value < 0 || value > 5)
            value = 5;

        if (value < 5) {
            List<Car> cars = new ArrayList<>();
            for (int i = 0; i < value; i++) {
                cars.add(carsList.get(i));
            }
            model.addAttribute("cars", cars);
        } else {
            model.addAttribute("cars", carsList);
        }
        return "cars";
    }
}