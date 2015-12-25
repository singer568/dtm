/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月24日 下午4:22:14
 */
package com.glodon.dtm.common.schedule.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
	
	@Around("execution(* com.glodon.transfer.service.ITransferDataService.transferData(..))")
	public void logArround(JoinPoint joinPoint) {
		
		System.out.println("Log arround run arround:" + joinPoint.getSignature().getName());
	}
	
}
