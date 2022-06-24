package alex.thymeleafxpressionsyntax.controller;


import alex.thymeleafxpressionsyntax.domain.Address;
import alex.thymeleafxpressionsyntax.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleExpressionController {

    @GetMapping("/simpleExpression")
    public String simpleExpression(Model model){
        Address address=new Address("Lyusinovskaya 41","105043");
        Person alex=new Person(10,"Alex",address);
        model.addAttribute("person",alex);
        return "simpleExpression";
    }
}
