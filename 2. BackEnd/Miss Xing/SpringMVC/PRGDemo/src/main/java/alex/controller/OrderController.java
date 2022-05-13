package alex.controller;

import alex.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {

    @GetMapping("/")
    public String orderForm(@ModelAttribute Order myOrder) {
        return "orderForm";
    }

    @PostMapping("saveOrder")
    public String saveOrder(Order o, RedirectAttributes redirectAttributes){
        //save to DB
        //redirectAttributes.addFlashAttribute("placedOrder",o);
        redirectAttributes.addFlashAttribute(o); //order
        System.out.println("Save to DB ....");
        return "redirect:/success";
    }


    @GetMapping("/success")
    public String success(){
        return "thankyou";
    }

}
