package com.training.aspects;

import java.time.LocalDate;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class MyAspect {

	Logger log=LoggerFactory.getLogger(MyAspect.class);
	
	@Before(value = "execution(* com.training.services.MyService.get*(..))") //PointCut Expn
	public void logBeforeAspect(JoinPoint joinPoint)
	{
		log.info("This is Before method..");
		String className=joinPoint.getTarget().getClass().toString();
		log.info("classname:"+className);
		log.info(""+joinPoint.getSignature());
	}
	
	@Before(value = "execution(* com.training.services.MyService.get*(..))") //PointCut Expn
	public void logBeforeAspect1(JoinPoint joinPoint)
	{
		log.info("This is Before1 method..");
		String className=joinPoint.getTarget().getClass().toString();
		log.info("classname:"+className);
		log.info(""+joinPoint.getSignature());
	}
	
	@After(value = "execution(* com.training.services.MyService.get*(..))") //PointCut Expn
	public void logAfterAspect(JoinPoint joinPoint)
	{
		log.info("This is After method.."+LocalDate.now());
		String className=joinPoint.getTarget().getClass().toString();
		log.info("classname:"+className);
		log.info(""+joinPoint.getSignature());
	}
	

	@Around(value = "execution(* com.training.services.MyService.get*(..))") //PointCut Expn
	public Object logAround(ProceedingJoinPoint joinPoint)
	{
		log.info("This is around method.."+LocalDate.now());
		String className=joinPoint.getTarget().getClass().toString();
		log.info("classname:"+className);
		log.info(""+joinPoint.getSignature());
		Object value=null;
		try {
			 value= joinPoint.proceed();
			 Object args[]=joinPoint.getArgs();
			log.info(Arrays.toString(args));
			// if(value==null)
			//	 throw new Exception("Exception");
			log.info("Value returned :"+value);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("before returning the method");
		return value;
	}
	
	@AfterThrowing(value = "execution(* com.training.services.MyService.get*(..))")
	public void logThrowAspect()
	{
		log.info("Throwing exception");
	}
	
	@AfterReturning(value = "execution(* com.training.services.MyService.get*(..))")
	public void logReturnAspect()
	{
		log.info("returning value");
	}
}
