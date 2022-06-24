package alex.controller;

import alex.model.Country;
import alex.model.Customer;
import alex.model.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String getCustomerForm(@ModelAttribute("customer") Customer customer, Model model){

        //1. List
        //List<String> countryList= Arrays.asList("United States", "Russia", "China");
        //model.addAttribute("countryList",countryList);

        //2. Map
       /* Map<String,String> countryMap= new HashMap<>();
        countryMap.put("US","United States");
        countryMap.put("CN","China");
        countryMap.put("RU","Russia");

        model.addAttribute("countryMap",countryMap);*/

        //3. List<Country>
        List<Country> countryObjectList = Arrays.asList(
                new Country("US","United States"),
                new Country("CN","China"),
                new Country("RU","Russia")
        );

        model.addAttribute("countryObjectList",countryObjectList);

        return "customerForm";

    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(Customer customer){
        //save to DB
        return "customerDetail";
    }

    @GetMapping("/edit")
    public String editCustomer(Model model){



        Phone p=new Phone("111","222","333");
        Country c=new Country("1","Russia");
        Customer customer = new Customer("Alex","Orlov",p,c);
        model.addAttribute("customer",customer);

        List<Country> countryObjectList = Arrays.asList(
                new Country("US","United States"),
                new Country("CN","China"),
                new Country("RU","Russia")
        );
        model.addAttribute("countryObjectList",countryObjectList);
        return "customerForm";



    }

}
