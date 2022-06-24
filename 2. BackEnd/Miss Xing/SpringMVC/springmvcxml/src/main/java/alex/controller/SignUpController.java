package alex.controller;

import alex.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = {"/user"})
public class SignUpController {

  // @RequestMapping(value = "/signup", method = RequestMethod.GET)
    @GetMapping(value = {"/", "/signup"})
    public String getSignUpForm(){
        return "signUpForm";
    }


    // @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @PostMapping("/save")
    public String saveUser(User user){
        System.out.println(user);
        return "result";
    }
}
