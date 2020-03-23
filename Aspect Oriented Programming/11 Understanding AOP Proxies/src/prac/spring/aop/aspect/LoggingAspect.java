package prac.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


public class LoggingAspect {
	
	//Both including before and after together=----around advice
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object internalObj=null;
		try {
			System.out.println("Before Advice");
			internalObj=proceedingJoinPoint.proceed();
			System.out.println(internalObj.getClass().getName());
			System.out.println("After Returning");
		} catch (Throwable e) {
			System.out.println("After Throwing");
			//e.printStackTrace();
		}
		System.out.println("After Finally");
		return internalObj;
	}

	public void loggingAdvice() {
		System.out.println("Logging the advice");
	}

}
