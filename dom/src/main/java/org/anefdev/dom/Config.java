package org.anefdev.dom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {


    @Value("${org.anefdev.name1}")
    String name1;
    @Value("${org.anefdev.name2}")
    String name2;

    @Bean
    public HelloWorld helloWorld1() {
        return new HelloWorld(name1);
    }

    @Bean
    public HelloWorld helloWorld2() {
        return new HelloWorld(name2);
    }
}
