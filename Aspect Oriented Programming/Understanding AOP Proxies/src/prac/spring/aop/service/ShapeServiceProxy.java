package prac.spring.aop.service;

import prac.spring.aop.aspect.Loggable;
import prac.spring.aop.aspect.LoggingAspect;
import prac.spring.aop.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	@Override
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}
