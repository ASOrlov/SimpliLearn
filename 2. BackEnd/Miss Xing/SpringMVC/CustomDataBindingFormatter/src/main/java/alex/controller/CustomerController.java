package alex.controller;

import alex.model.Customer;
import alex.model.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String getCustomerForm(){
        return "customerForm";

    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(Customer customer){
        //save to DB
        return "customerDetail";
    }

    @GetMapping("/edit")
    public String editCustomer(Model model){

        Phone p=new Phone("123","456","789");
        Customer customer = new Customer("Alex","Orlov",p);
        model.addAttribute("customer",customer);
        return "customerEditForm";



    }

}
