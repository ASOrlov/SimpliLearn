package alex.ModelScopedAttributeXML.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/session")
@SessionAttributes({"channelName","hello"})
public class SessionScopeAttributeController {

    @GetMapping("/")
    public String setSessionAttribute(Model model, HttpSession httpSession){
        model.addAttribute("channelName","Movie channell ....");
        model.addAttribute("hello","World");

        httpSession.setAttribute("authorName", "Alex");
        httpSession.setAttribute("channelName","Thank you ...");


        //when you use httpSession to add Sesssion Attribute, it will add immediately
        //when you use @SessionAttribute to add attribute, it will add just before the page rendering,
        //before the current request ends


        return "redirect:/session/display";
    }

    @GetMapping("/display")
    public String display(SessionStatus status){

        //Only remove attribute set by using @SessionAttribute
        //It removes attribute from session scope after the page rendering
        status.setComplete();
        return "sessionScopeAttribute";
    }

}
