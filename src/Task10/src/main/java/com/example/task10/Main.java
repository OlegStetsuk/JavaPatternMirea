package com.example.task10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProgrammerConfiguration.class);
        Programmer junior = context.getBean(Junior.class);
        Programmer middle = context.getBean(Middle.class);
        Programmer senior = context.getBean(Senior.class);
        junior.doCoding();
        middle.doCoding();
        senior.doCoding();
    }
}
