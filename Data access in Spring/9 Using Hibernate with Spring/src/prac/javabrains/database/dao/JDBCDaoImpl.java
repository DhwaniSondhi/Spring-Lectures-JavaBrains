package prac.javabrains.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import prac.javabrains.database.model.Circle;

public class JDBCDaoImpl extends JdbcDaoSupport {

	private static final class CircleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Circle(rs.getInt("id"),rs.getString("name"));
		}
		
	}
	
	public int getCircleCount() {
		String query="SELECT COUNT(*) FROM circle";
		Integer count= this.getJdbcTemplate().queryForObject(query, Integer.class);
		if (count==null) {
			return 0;
		}
		return count;
	}
	
	public String getCircleName(int circleID) {
		String query="SELECT name FROM circle WHERE ID=?";
		String name= this.getJdbcTemplate().queryForObject(query, new Object[] {circleID}, String.class);
		return name;
	}
	
	public Circle getCircleForId(int circleID) {
		String query="SELECT * FROM circle WHERE ID=?";
		return this.getJdbcTemplate().queryForObject(query, new Object[] {circleID}, new CircleMapper());
	}
	
	public List<Circle> getAllCircles(){
		String query="SELECT * FROM circle";
		return this.getJdbcTemplate().query(query, new CircleMapper());
	}
	
	public boolean insertCircle(Circle circle) {
		String query="INSERT INTO circle(ID,NAME) VALUES (?,?)";
		try {
			this.getJdbcTemplate().update(query, new Object[] {circle.getId(),circle.getName()});
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
		this.getJdbcTemplate().execute(query);
	}
	
	
}
