package com.maojiu;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser1 {
    @Test
    public void testUser1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User1 user1 = applicationContext.getBean("user1", User1.class);
        System.out.println(user1);
    }
}
