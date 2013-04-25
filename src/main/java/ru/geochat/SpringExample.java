package ru.geochat;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringExample {
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("//home/lukash/projects/GeoChat/src/main/java/applicationContext.xml");
		BusinessClass bean = (BusinessClass) ctx.getBean("first");
		System.out.println(bean.getName() + " " + bean.getAddress());
		System.err.println(bean.getSomeBean().getSomeVal());
	}
}
