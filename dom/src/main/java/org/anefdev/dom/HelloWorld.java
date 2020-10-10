package org.anefdev.dom;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


public class HelloWorld implements ApplicationRunner {

    String name;

    public HelloWorld(String name) {
        this.name = name;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello " + name);
    }
}
