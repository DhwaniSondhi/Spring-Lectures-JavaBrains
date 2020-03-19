package prac.javabrains.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import prac.javabrains.database.model.Circle;

@Component("jdbcDaoImpl")
public class JDBCDaoImpl {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private static final class CircleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Circle(rs.getInt("id"),rs.getString("name"));
		}
		
	}
	
	
	/*public Circle getCircle(int id) {
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
	*/
	
	
	public int getCircleCount() {
		String query="SELECT COUNT(*) FROM circle";
		Integer count= jdbcTemplate.queryForObject(query, Integer.class);
		if (count==null) {
			return 0;
		}
		return count;
	}
	public String getCircleName(int circleID) {
		String query="SELECT name FROM circle WHERE ID=?";
		String name= jdbcTemplate.queryForObject(query, new Object[] {circleID}, String.class);
		return name;
	}

	public Circle getCircleForId(int circleID) {
		String query="SELECT * FROM circle WHERE ID=?";
		return jdbcTemplate.queryForObject(query, new Object[] {circleID}, new CircleMapper());
	}
	
	public List<Circle> getAllCircles(){
		String query="SELECT * FROM circle";
		return jdbcTemplate.query(query, new CircleMapper());
	}
	
	public boolean insertCircle(Circle circle) {
		String query="INSERT INTO circle(ID,NAME) VALUES (?,?)";
		try {
			jdbcTemplate.update(query, new Object[] {circle.getId(),circle.getName()});
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void createTriangleTable() {
		String query="CREATE TABLE triangle("
					+"ID Integer,"
					+ "NAME VARCHAR(50))";
		jdbcTemplate.execute(query);
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
