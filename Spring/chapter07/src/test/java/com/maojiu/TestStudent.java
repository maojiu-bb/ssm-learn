package com.maojiu;

import com.maojiu.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
    @Test
    public void test() {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationStudent.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
        applicationContext.registerShutdownHook();
    }
}
