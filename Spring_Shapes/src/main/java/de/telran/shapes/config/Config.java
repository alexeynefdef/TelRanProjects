package de.telran.shapes.config;

import de.telran.shapes.model.Line;
import de.telran.shapes.model.Picture;
import de.telran.shapes.model.Rectangle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {

    @Bean
    public Line line1() {
        return new Line('*',10);
    }

    @Bean
    public Line line2() {
        return new Line('>',20);
    }

    @Bean
    public Rectangle rectangle1() {
        return new Rectangle('°',20,10);
    }

    @Bean
    public Rectangle rectangle2() {
        return new Rectangle('$',25,10);
    }

    @Bean
    public Picture pic1(Line line1, Rectangle rectangle1){
        return new Picture(List.of(line1,rectangle1));
    }
}
