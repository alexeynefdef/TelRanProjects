package org.anefdef;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MyBean myBean = context.getBean("myBean", MyBean.class);

        System.out.println(myBean.getName());

        context.close();
    }
}
