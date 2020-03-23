package prac.spring.aop.service;

import prac.spring.aop.model.Circle;
import prac.spring.aop.model.Triangle;

public class ShapeService {
	private Circle circle;
	private Triangle triangle;
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
}
