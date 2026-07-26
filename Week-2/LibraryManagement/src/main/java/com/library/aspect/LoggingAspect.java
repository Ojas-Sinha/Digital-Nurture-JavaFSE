package com.library.aspect;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {
	
	public void beforeMethod(JoinPoint jp) {

        System.out.println("Before Method : " + jp.getSignature().getName());

    }

    public void afterMethod(JoinPoint jp) {

        System.out.println("After Method : " + jp.getSignature().getName());

    }

}
