package com.zhanghao.core.aop;

import java.io.IOException;
import java.io.PrintStream;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAopTest {

	@Pointcut("execution(* com.zhanghao.inf.user.service.impl.PmsUserServiceImpl.*(..))")
	public void poiniCut() {
		System.err.println("切入关注点");
	}

	@Before("poiniCut()")
	public void doAccessCheck(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		System.out.println(className + "的" + methodName + "执行了");
		Object[] args = joinPoint.getArgs();
		StringBuilder log = new StringBuilder("入参为");
		for (Object arg : args) {
			log.append(arg + " ");
		}
		System.out.println(log.toString());
	}

	@AfterReturning(value = "poiniCut()", returning = "returnVal")
	public void doAfter(Object returnVal) throws Throwable {
		System.out.println("方法正常结束了,方法的返回值:" + returnVal);
		// Object proceed = point.proceed();
		// System.out.println("方法的返回值是"+proceed);
	}

	@After("poiniCut()")
	public void doFinish() {
		System.out.println("进入最终通知，关闭资源");
	}

	@AfterThrowing(value = "poiniCut()", throwing = "e")
	public void doAftereThrow(Exception e) throws IOException {
		PrintStream s=new PrintStream(System.out);
		s.write("异常堆栈信息为：".getBytes());
		e.printStackTrace(s);
		System.out.println("执行目标方法发生了异常，异常信息为:" + e);
	}

	@Around("poiniCut()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("进入环绕通知");
		Object object = null;// 执行该方法
		long start =System.currentTimeMillis();
		object = pjp.proceed();
		long end =System.currentTimeMillis();
		System.out.println("耗时："+(end-start));
		System.out.println("退出方法");
		return object;
	}
}
