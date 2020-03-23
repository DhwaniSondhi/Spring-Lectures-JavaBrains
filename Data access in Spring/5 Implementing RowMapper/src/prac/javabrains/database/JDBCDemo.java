package prac.javabrains.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import prac.javabrains.database.dao.JDBCDaoImpl;
import prac.javabrains.database.model.Circle;

public class JDBCDemo {
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		JDBCDaoImpl dao=(JDBCDaoImpl)context.getBean("jdbcDaoImpl", JDBCDaoImpl.class);
		System.out.println(dao.getCircleCount());
		System.out.println(dao.getCircleName(1));
		System.out.println(dao.getCircleForId(1).getName());
		System.out.println(dao.getAllCircles().size());
		for(Circle circle:dao.getAllCircles()) {
			System.out.println(circle.getName());
		}
		//Circle circle=dao.getCircle(1);
		//System.out.println(circle.getName());
	}
}
