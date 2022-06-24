package alex.thymeleafxpressionsyntax.controller;

import alex.thymeleafxpressionsyntax.domain.Address;
import alex.thymeleafxpressionsyntax.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConditionalController {

    @GetMapping("/conditionalExpression")
    public String conditionalExpression(Model model) {
        Address address = new Address("Lyusinovskaya 41", "105043");
        Person alex1 = new Person(10, "Alex", address);
        Person alex2 = new Person(10, "Orlov", null);
        model.addAttribute("person1", alex1);
        model.addAttribute("person2", alex2);
        model.addAttribute("gender","F");
        return "conditionalExpression";
    }
}