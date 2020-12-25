package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

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
        ArrayList<Car> carsList = new ArrayList<>();

        carsList.add(new Car("Car1", "123", 2001));
        carsList.add(new Car("Car2", "234", 2002));
        carsList.add(new Car("Car3", "345", 2003));
        carsList.add(new Car("Car4", "456", 2004));
        carsList.add(new Car("Car5", "567", 2005));

        int value = Integer.parseInt(param);

        if (value < 0 || value > 5)
            value = 5;

        if (value < 5) {
            ArrayList<Car> cars = new ArrayList<>();
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