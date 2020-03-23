package prac.spring.aop.service;

import prac.spring.aop.model.Circle;
import prac.spring.aop.model.Triangle;

public class FactoryService {

	public Object getBean(String beanType) {
		if(beanType.equals("ShapeService"))				return new ShapeServiceProxy();
		else if(beanType.equals("Circle"))				return new Circle();
		else if(beanType.equals("Triangle"))				return new Triangle();
		return null;
	}
}
