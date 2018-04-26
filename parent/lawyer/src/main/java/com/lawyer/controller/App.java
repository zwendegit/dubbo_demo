package com.lawyer.controller;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
		try {
			 System.out.println( "Hello World!" );
			 System.out.println("git commit test!");
			 //测试时候执行
//			 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			 //打jar包执行
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-servlet.xml","classpath:spring-dubbo.xml"} );
			context.start();
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
