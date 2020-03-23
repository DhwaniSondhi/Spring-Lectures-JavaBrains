package prac.javabrains.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import prac.javabrains.database.model.Circle;

@Component("jdbcDaoImpl")
public class JDBCDaoImpl {

	@Autowired
	private DataSource dataSource;
	
	public Circle getCircle(int id) {
		Connection connection=null;
		Circle circle=null;
		PreparedStatement ps=null;
		
		ResultSet rs=null;
		try {
			connection=dataSource.getConnection();
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

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	
}
