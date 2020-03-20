package prac.javabrains.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import prac.javabrains.database.dao.HibernateDaoImpl;
import prac.javabrains.database.dao.JDBCDaoImpl;
import prac.javabrains.database.model.Circle;

public class JDBCDemo {
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		HibernateDaoImpl dao=(HibernateDaoImpl)context.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		System.out.println(dao.getAllCircles().size());
		dao.insertCircle(new Circle(1, "First"));
		dao.insertCircle(new Circle(2, "Second"));
		dao.insertCircle(new Circle(3, "Third"));
		dao.insertCircle(new Circle(4, "Fourth"));
		dao.insertCircle(new Circle(5, "Fifth"));
		System.out.println(dao.getAllCircles().size());
		System.out.println(dao.getCircleName(1));
		System.out.println(dao.getCircleForId(1).getName());
		for(Circle circle:dao.getAllCircles()) {
			System.out.println(circle.getName());
		}
		dao.insertCircle(new Circle(6,"Sixth"));
		System.out.println(dao.getAllCircles().size());
		//dao.createTriangleTable();	
	}
}
