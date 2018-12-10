package com.aaa.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * className:logUtil
 * discription:通知类（切面的实现类）
 * author:zz
 * createTime:2018-11-23 18:02
 */
@Component
@Aspect
public class logUtil {
    /**
     * 切入点配置
     */
    @Pointcut(value = "execution(* com.aaa.service.*.*(..))")
    public void pointCutOne(){

    }

    /**
     * 前置通知
     * @param joinPoint
     */
   // @Before(value = "pointCutOne()")
    public void beforeSaveLog(JoinPoint joinPoint){
        System.out.println("在调用"+joinPoint.getSignature().getName()+"方法之前，打印。。。");
    }

    /**
     * 后置通知
     * @param joinPoint
     */
    @After(value = "pointCutOne()")
    public void afterReturningSaveLog(JoinPoint joinPoint){
        System.out.println("在调用"+joinPoint.getSignature().getName()+"方法之后，打印。。。");

    }

    /**
     * 异常通知
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "pointCutOne()",throwing = "e")
    public void afterThrowingSaveLog(JoinPoint joinPoint,Exception e){
        System.out.println("在调用"+joinPoint.getSignature().getName()+"方法时出现了"+e.getClass().getName()+"异常，异常描述："+e.getMessage());

    }
    /**
     * 最终通知
     */
    @AfterReturning(value = "pointCutOne()")
    public void afterSaveLog(JoinPoint joinPoint){
        System.out.println("在调用"+joinPoint.getSignature().getName()+"方法时，无论有没有异常都会打印。。。");

    }
    /**
     * 环绕通知
     */
    public Object aroundSaveLog(ProceedingJoinPoint proceedingJoinPoint){
        Object proceed = null;
        System.out.println(System.currentTimeMillis()+"执行业务方法之前---");
        try {

            proceed =  proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()+"执行业务方法之后---");
        return proceed;
    }
}
