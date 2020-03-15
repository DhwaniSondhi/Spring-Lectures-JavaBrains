package prac.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import prac.spring.aop.model.Circle;

@Aspect
public class LoggingAspect {
	
	
	@Before("allCircleMethod()")
	public void advice(JoinPoint joinPoint) {
		System.out.println(joinPoint.toString());
		Circle circle=(Circle)joinPoint.getTarget();
		System.out.println(circle.getName());
	}
	
	@Before("args(name)")
	public void stringAdvice(String name) {
		System.out.println("String method called with value: "+name);
	}
	
	//within for above pointcut for all methods in a class
	@Pointcut("within(prac.spring.aop.model.Circle)")
	public void allCircleMethod() {}
	
	
}
