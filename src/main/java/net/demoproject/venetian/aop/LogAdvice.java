package net.demoproject.venetian.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {

    @Pointcut("execution(* net.demoproject.venetian.service.impl.VideoServiceImpl.*(..))")
    public void aspect(){

    }

    @Before("aspect()")
    public void beforeLog(JoinPoint joinPoint)
    {
        System.out.println("LogAdvice beforeLog");
    }

    @After("aspect()")
    public void afterLog(JoinPoint joinPoint){
        System.out.println("LogAdvice afterLog");
    }

}
