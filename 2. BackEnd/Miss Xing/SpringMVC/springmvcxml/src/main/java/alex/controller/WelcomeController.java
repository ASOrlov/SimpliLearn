package alex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping("/")
    public String welcome(){
       // return "/WEB-INF/jsp/welcome.jsp";
        return "welcome";
    }

}
