package prac.javabrains.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo="Circle")
public class Circle {

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private int id;
	
	@Column(name = "NAME", unique = false, nullable = false, length = 100)
	private String name;
	
	
	public Circle(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Circle() {
		super();
	}
	
}
