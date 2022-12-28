package com.utility.app.aspect;

import com.utility.app.threads.SecurityContext;
import com.utility.app.threads.TheUserInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Aspect
@Component
public class LogTimeAspect {
    Logger logger = LoggerFactory.getLogger(LogTimeAspect.class);

//    @Autowired(required = false)
//    private HttpServletRequest httpServletRequest;
    @Around("execution(* com.utility.app.controller..*(..))")
    public void validateUserToken(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("we are in validateUserToken");
        String clazzName  = joinPoint.getTarget().getClass().getSimpleName().replace("Controller","");
        System.out.println("URI : "+clazzName);
        String token = "";
        TheUserInfo userInfo = new TheUserInfo();
        userInfo.setUsername("Ahmed Alaa");
        SecurityContext.setUserInfo(userInfo);
        joinPoint.proceed();
        SecurityContext.clearUserInfo();
    }

    @Around("execution(* com.utility.app.service..*(..))")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startAt = System.currentTimeMillis();
        logger.info("this service starts at : " + startAt);
        logger.info("Service Signature : " + joinPoint);
        logger.info("Service Target : " + joinPoint.getTarget());
        logger.info("Service Args : " + joinPoint.getArgs());
        logger.info("Service Kind : " + joinPoint.getKind());
        Object obj = null;
        try {
            obj = joinPoint.proceed();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
         //   System.out.println("we are in log erorr testing 1111 ");
        }
        logger.info("this service end at : " + System.currentTimeMillis());
        return obj;
    }

//    @Before(value = "execution(* com.utility.app.service..save(..))")
//    public void logBeforeAction(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        logger.info("start executing method : " + name);
//        logger.info(joinPoint.getArgs().toString());
//        Object[] objs = joinPoint.getArgs();
//        for (Object obj : objs) {
//            logger.info(obj.toString());
//        }
//    }

//    @After(value = "execution(* com.utility.app.service..save2(..))")
//    public void logAfterAction(JoinPoint joinPoint) {
//        try {
//            String name = joinPoint.getSignature().getName();
//            logger.info("logAfterAction end executing method : " + name);
//            logger.info(joinPoint.getArgs().toString());
//            Object[] objs = joinPoint.getArgs();
//            for (Object obj : objs) {
//                logger.info(obj.toString());
//            }
//        } catch (Exception ex) {
//            logger.info("logAfterAction");
//            logger.error(ex.toString());
//        }
//    }
//
//    @AfterReturning(value = "execution(* com.utility.app.controller..*(..))", returning = "object")
//    public void logAfterReturnAction(JoinPoint joinPoint, Object object) {
//        System.out.println("we are in logAfterReturn");
//        String name = joinPoint.getSignature().getName();
//        logger.info("logAfterReturnAction end executing method : " + name);
//        logger.info(object.toString());
//
//    }
//
//    @AfterThrowing(value = "execution(* com.utility.app.service..save2(..))", throwing = "error")
//    public void logAfterThrowAction(JoinPoint joinPoint, Throwable error) {
//        String name = joinPoint.getSignature().getName();
//        logger.info("logAfterThrowAction method : " + name);
//        logger.info(error.toString());
//
//    }
}
