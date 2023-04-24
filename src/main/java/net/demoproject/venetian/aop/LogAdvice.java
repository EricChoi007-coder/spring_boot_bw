package net.demoproject.venetian.aop;

import net.demoproject.venetian.customException.CustomException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.Console;

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

    @AfterThrowing(pointcut = "aspect()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Throwable e){
        if (e instanceof CustomException) {
            System.out.println("客制化获到异常了..............");
            //纪录错误信息
            System.out.println("客制化错误:"+ ((CustomException) e).getErrorInfo());
        }else{
            System.out.println("全局捕获到异常了..............");
            //纪录错误信息
            System.out.println("系统错误:{}"+ e.getMessage());
            // todo 想要执行的操作
        }

    }
}
