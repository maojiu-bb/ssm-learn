package com.maojiu;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean1 {
    @Test
    public void testBean1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationBean1.xml");
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
        System.out.println(bean1);
    }
}
