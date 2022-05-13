package com.ecommerce.controller;

import com.ecommerce.beans.CustomEventPublisher;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



@Controller
public class MainController {

    @RequestMapping(value = "/customevent", method = RequestMethod.GET)
    public String customEvent(ModelMap map)
    {
        String confFile = "spring.xml";
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);


        context.start();

        CustomEventPublisher cvp =
                (CustomEventPublisher) context.getBean("customEventPublisher");

        cvp.publish();

        context.stop();

        return "customEvent";
    }

}
