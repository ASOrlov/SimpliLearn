package alex.thymeleafxpressionsyntax.controller;


import alex.thymeleafxpressionsyntax.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class IterationalController {

    @GetMapping("/iterationalExpression")
    public String iterationalExpression(Model model){

        List<Person> people = Arrays.asList(
                new Person(45,"Alex"),
                new Person(54,"Katya"),
                new Person(34,"Yaskee")
        );


        model.addAttribute("people",people);
        return "iterationalExpression";

    }
}
