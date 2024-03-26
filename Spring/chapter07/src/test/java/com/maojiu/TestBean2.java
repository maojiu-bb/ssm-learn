package com.maojiu;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean2 {
    @Test
    public void testBean2 () {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationBean2.xml");
        Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
        System.out.println(bean2);
    }
}
