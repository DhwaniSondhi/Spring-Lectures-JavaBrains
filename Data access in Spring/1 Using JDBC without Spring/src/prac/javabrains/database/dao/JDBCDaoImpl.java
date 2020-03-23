package prac.javabrains.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import prac.javabrains.database.model.Circle;

public class JDBCDaoImpl {

	public Circle getCircle(int id) {
		Connection connection=null;
		String driver="org.apache.derby.jdbc.ClientDriver";
		Circle circle=null;
		PreparedStatement ps=null;
		
		ResultSet rs=null;
		try {
			Class.forName(driver).newInstance();
			connection=DriverManager.getConnection("jdbc:derby://localhost:1527/db");
			ps=connection.prepareStatement("SELECT * FROM circle where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				circle=new Circle(id, rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return circle;
	}
	
}
