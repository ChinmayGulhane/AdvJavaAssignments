package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.demo.model.HelloWorld;
import com.demo.model.Myuser;

public class TestHello {
		public static void main(String[] args) {
			//BeanFactory bc=new XmlBeanFactory(new ClassPathResource("springconfig.xml"));
			ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
			System.out.println("before");
			HelloWorld hello=(HelloWorld) ctx.getBean("hw");
			System.out.println("after");
			System.out.println(hello.sayHello());
			HelloWorld hello1=(HelloWorld) ctx.getBean("hw");
			System.out.println(hello1.sayHello());
			Myuser user1=(Myuser) ctx.getBean("u1");
			System.out.println(user1);
			Myuser user3=(Myuser) ctx.getBean("u3");
			System.out.println(user3);
		}
}