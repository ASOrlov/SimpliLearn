package javaconfig;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Customer {
    public Customer() {
        System.out.println("Default constructor ....");
    }


    @PostConstruct
    public void customInit(){
        System.out.println("Custom Init ....");
    }

    @PreDestroy
    public void customDestroy(){
        System.out.println("Custom Destroy ....");
    }
}
