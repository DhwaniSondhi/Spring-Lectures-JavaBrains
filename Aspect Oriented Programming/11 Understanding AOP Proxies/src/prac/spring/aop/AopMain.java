package prac.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import prac.spring.aop.service.FactoryService;
import prac.spring.aop.service.ShapeService;

public class AopMain {
	public static void main(String[] args) {
		//ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		//ShapeService shapeService=context.getBean("shapeService",ShapeService.class);
		
		FactoryService fservice=new FactoryService();
		System.out.println(((ShapeService)fservice.getBean("ShapeService")).getCircle());
		//System.out.println(shapeService.getTriangle().getName());
	}
}
