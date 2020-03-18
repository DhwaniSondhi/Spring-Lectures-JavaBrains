package prac.javabrains.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import prac.javabrains.database.model.Circle;

@Component("jdbcDaoImpl")
public class JDBCDaoImpl {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
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
	
	public int getCircleCount() {
		String query="SELECT COUNT(*) FROM circle";
		Integer count= jdbcTemplate.queryForObject(query, Integer.class);
		if (count==null) {
			return 0;
		}
		return count;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
}
