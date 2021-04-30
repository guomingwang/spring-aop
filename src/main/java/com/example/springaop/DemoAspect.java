package com.example.springaop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author wgm
 * @since 2021/4/30
 */
@Aspect
@Slf4j
@Component
public class DemoAspect {

    @Pointcut("execution(public void com.example.springaop.DemoService.test(boolean))")
    public void pointcut() {}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        System.out.println("Around");
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
        }
        System.out.println("Around");
        return proceed;
    }

    @Before("pointcut()")
    public void before() {
        System.out.println("Before");
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("AfterReturning");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("AfterThrowing");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("After");
    }
}
