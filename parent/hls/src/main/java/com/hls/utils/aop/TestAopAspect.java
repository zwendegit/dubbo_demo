package com.hls.utils.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @throws Throwable 
 * @Pointcut 通过@Pointcut 指定切入点 ，这里指定的切入点为MyLog注解类型，也就是被@MyLog注解修饰的方法，进入该切入点。
 * @Before 前置通知：在某连接点之前执行的通知，但这个通知不能阻止连接点之前的执行流程（除非它抛出一个异常）。
 * @Around 环绕通知：可以实现方法执行前后操作，需要在方法内执行point.proceed(); 并返回结果。
   @AfterReturning 后置通知：在某连接点正常完成后执行的通知：例如，一个方法没有抛出任何异常，正常返回。
   @AfterThrowing 异常通知：在方法抛出异常退出时执行的通知。
   @After 后置通知：在某连接点正常完成后执行的通知：例如，一个方法没有抛出任何异常，正常返回。
 */
@Component
@Aspect//定义为切面
public class TestAopAspect {

	 @Pointcut(value="@annotation(com.hls.utils.aop.TestAop)")
	 public void pointcut(){
		 
	 }
	 /**
	  * @throws Throwable 
	  * @Around 环绕通知：可以实现方法执行前后操作，需要在方法内执行point.proceed(); 并返回结果。
	  */
	 @SuppressWarnings(value = { "all" })
	 @Around(value = "pointcut() && @annotation(myLog)")
	 public Object aroundDoSomething(ProceedingJoinPoint point, TestAop myLog) throws Throwable{
		 String message=myLog.requestUrl();
		 //获取类名
	     Class clazz = point.getTarget().getClass();
	     //获取方法名
	     Method method = ((MethodSignature) point.getSignature()).getMethod();
	     System.out.println("执行了Around方法,message="+message+",class="+clazz+",method="+method);
		 return point.proceed();
	 }
}
