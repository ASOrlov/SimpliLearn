package com.ecommerce.beans;

import com.ecommerce.beans.CustomEvent;
import org.springframework.context.ApplicationListener;

public class CustomEventListener implements ApplicationListener<CustomEvent> {

    public void onApplicationEvent(CustomEvent event) {
        System.out.println("From custom event listener "+event.toString());
    }
}
