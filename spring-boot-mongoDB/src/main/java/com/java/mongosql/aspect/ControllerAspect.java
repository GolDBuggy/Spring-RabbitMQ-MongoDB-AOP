package com.java.mongosql.aspect;

import com.java.mongosql.entity.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
public class ControllerAspect {

    private Logger logger=Logger.getLogger(ControllerAspect.class.getName());

    @Before("execution(* com.java.mongosql.controller.ProductController.*(..))")
    public void requestExecution(JoinPoint joinPoint){
        MethodSignature signature=(MethodSignature) joinPoint.getSignature();
        logger.info(signature.getName()+" method is worked!");
    }

    @AfterReturning(value = "execution(* com.java.mongosql.controller.ProductController.*(..))",returning = "products")
    public void returnList(ResponseEntity<List<Product>>products){
        logger.info("After returning value = "+products);
    }


    @AfterThrowing(value = "execution(* com.java.mongosql.controller.ProductController.*(..))",throwing = "exc")
    public void returnList(JoinPoint joinPoint,RuntimeException exc){
        MethodSignature signature=(MethodSignature) joinPoint.getSignature();
        logger.info(""+exc.getMessage());
    }



}
