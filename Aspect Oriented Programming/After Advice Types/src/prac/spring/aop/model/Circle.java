package prac.spring.aop.model;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Setter called");
		//throw(new RuntimeException());
	}
	
	public String setNameAndReturnString(String name) {
		this.name = name;
		System.out.println("Setter called");
		return name;
	}
	
	public int setNameAndReturnObject(String name) {
		this.name = name;
		System.out.println("Setter called");
		return 1;
	}
}
