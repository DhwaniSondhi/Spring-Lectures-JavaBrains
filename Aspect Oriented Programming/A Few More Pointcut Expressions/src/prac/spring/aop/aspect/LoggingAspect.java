package prac.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("allTriangleMethod()")
	public void advice1() {
		System.out.println("Second Advice 1 run.");
	}
	
	@Before("allGetters()")
	public void advice2() {
		System.out.println("Second Advice 2 run.");
	}
	
	@Before("allMethod()")
	public void advice3() {
		System.out.println("Second Advice 3 run.");
	}
	
	@Before("allMethod()  &&  allTriangleMethod()")
	public void advice4() {
		System.out.println("Second Advice 4 run.");
	}
	
	@Pointcut("execution(* prac.spring.aop.model.Circle.*(..))")
	public void allGetters() {
	}
	
	//within for above pointcut for all methods in a class
	@Pointcut("within(prac.spring.aop.model.Triangle)")
	public void allTriangleMethod() {}
	
	@Pointcut("within(prac.spring.aop.model.*)")
	public void allMethod() {}
	
	//@Pointcut(args())
	
	
}
