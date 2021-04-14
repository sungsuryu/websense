package com.isensoft.websense.demo.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Aspect
@Component
@Order(0)
public class PreProcessAspect {
	
	@Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
	public void restcontroller() {}
	
	@Pointcut("within(com.isensoft.websense.demo.controller.*)")
	public void allcontroller() {}
	
	@Pointcut("within(com.isensoft.websense.demo.controller.DemoController)")
	public void demoController() {}
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
	public void postmapping() {}
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void getmapping() {}
	
	@Before("demoController() && postmapping() && args(.., @RequestBody body, bindingResult)")
	public void checkPreProcess(JoinPoint joinPoint, Object body, BindingResult bindingResult) throws Throwable {
		
		String methodName = joinPoint.getSignature().getName();
		
		log.info("AOP - method name :{}", methodName);
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		
		String uri = request.getRequestURI();
		String apiName = uri.substring(uri.lastIndexOf("/")+1, uri.length());
		
		log.info("AOP - uri : {}", uri);
		log.info("ADO api-name : {}", apiName);
	}
}
