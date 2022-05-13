package alex.ModelScopedAttributeXML.controller;

import alex.ModelScopedAttributeXML.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RequestScopeAttributeController {

    @GetMapping("/")
    public String requestAttribute(Model model, HttpServletRequest request){
        model.addAttribute("channelName","Super movie");
        model.addAttribute("year",2019);

        Customer customer=new Customer(1,"Alex");
        model.addAttribute("customer",customer);
        model.addAttribute("abc"); //string=abc
        model.addAttribute(12.0);//double=12.0

        request.setAttribute("authorName","Alex");
        return "redirect:/display";
    }

    @GetMapping("/display")
    public String displayRequestAttribute(){
        return "requestScopeAttribute";
    }
}
