package prac.javabrains.database;

import prac.javabrains.database.dao.JDBCDaoImpl;
import prac.javabrains.database.model.Circle;

public class JDBCDemo {
	
	public static void main(String[] args) {
		Circle circle=new JDBCDaoImpl().getCircle(1);
		System.out.println(circle.getName());
	}
}
