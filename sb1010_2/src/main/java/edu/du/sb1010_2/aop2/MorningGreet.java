package edu.du.sb1010_2.aop2;

import org.springframework.stereotype.Component;

//@Component
public class MorningGreet implements Greet {

    @Override
    public void greeting() {
        System.out.println("----------------");
        System.out.println("Morning Greet");
        System.out.println("----------------");
    }
}
