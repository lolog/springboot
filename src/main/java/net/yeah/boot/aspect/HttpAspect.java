package net.yeah.boot.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * net.yeah.boot.controller.*.*(..))")
    public void pointcut () {
    }

    @Before("pointcut()")
    public void doBefore (JoinPoint joinPoint) {
        // url
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}", request.getRequestURL());

        // method
        logger.info("method={}", request.getMethod());

        // ip
        logger.info("ip={}", request.getRemoteAddr());

        // class
        logger.info("class method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        // param
        logger.info("args={}", joinPoint.getArgs());

        logger.info("----doBefore---");
    }

    @After("pointcut()")
    public void doAfter () {
        logger.info("----doAfter---");
    }

    @AfterReturning(pointcut = "pointcut()", returning = "object")
    public void doAfterReturning (Object object) {
        logger.info("response={}", object);
    }
}
