package prac.spring.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class LoggingAspect {

	//advice run after method ends
	@After("args(name)")
	public void advice1(String name) {
		System.out.println("advice1: "+name);
	}

	//advice run only when method is returning correctly
	@AfterReturning("args(name)")
	public void advice2(String name) {
		System.out.println("advice2: "+name);
	}

	//to get the return string
	@AfterReturning(pointcut="args(name)", returning="returnString")	
	public void returnAdvice(String name, String returnString) {
		System.out.println("Input value: "+name+"  ***  Return string: "+returnString);
	}

	//to get the return int
	@AfterReturning(pointcut="args(name)", returning="returnString")	
	public void returnAdvice(String name, int returnString) {
		System.out.println("Input value: "+name+"  ***  Return string: "+returnString);
	}
	 
	//to get the return object
	@AfterReturning(pointcut="args(name)", returning="returnString")	
	public void returnAdvice(String name, Object returnString) {
		System.out.println("Input value: "+name+"  ***  Return string: "+returnString);
	}

	
	//advice run after exception is thrown
	@AfterThrowing("args(name)")
	public void advice3(String name) {
		System.out.println("exception: "+name);
	}

	//to get the return exception
	@AfterThrowing(pointcut="args(name)", throwing="ex")	
	public void expection(String name, RuntimeException ex) {
		System.out.println("Input value: "+name+"  ***  Return exception: "+ex);
	}


}
