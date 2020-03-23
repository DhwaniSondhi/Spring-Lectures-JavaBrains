package prac.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import prac.spring.aop.service.ShapeService;

public class AopMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService=context.getBean("shapeService",ShapeService.class);
		shapeService.getCircle().setName("New name");
		shapeService.getCircle().setNameAndReturnObject("New name");
		shapeService.getCircle().setNameAndReturnString("New name");
	}
}
