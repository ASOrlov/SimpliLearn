package alex.task207.controllers;
import alex.task207.beans.Quote;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {


        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote.class);
        return quote.toString();
    }


}
