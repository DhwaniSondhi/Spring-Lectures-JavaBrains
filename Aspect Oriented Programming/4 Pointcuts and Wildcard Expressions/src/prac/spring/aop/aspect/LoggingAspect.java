package prac.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	// only for circle getName() function
	@Before("execution(public String prac.spring.aop.model.Circle.getName())")
	public void loggingAdvice1() {
		System.out.println("Advice 1 run. Get Method Called.");
	}

	// for all getters
	@Before("execution(public * get*())")
	public void loggingAdvice2() {
		System.out.println("Advice 2 run. Get Method Called.");
	}

	// for all getters even private or public
	@Before("execution(* get*())")
	public void loggingAdvice3() {
		System.out.println("Advice 3 run. Get Method Called.");
	}

	// for all getters with 1 to any number of arguments
	@Before("execution(* get*(*))")
	public void loggingAdvice4() {
		System.out.println("Advice 4 run. Get Method Called.");
	}

	// for all getters with 0 to any number of arguments
	@Before("execution(* get*(..))")
	public void loggingAdvice5() {
		System.out.println("Advice 5 run. Get Method Called.");
	}

	// for all getters with 0 to any number of arguments
	@Before("execution(* prac.spring.aop.model.*.get*(..))")
	public void loggingAdvice6() {
		System.out.println("Advice 6 run. Get Method Called.");
	}

	@Pointcut("execution(* get*())")
	public void allGetters() {
	}
	
	@Before("allGetters()")
	public void secondAdvice1() {
		System.out.println("Second Advice 1 run.");
	}
	
	@Before("allGetters()")
	public void secondAdvice2() {
		System.out.println("Second Advice 2 run.");
	}

}
