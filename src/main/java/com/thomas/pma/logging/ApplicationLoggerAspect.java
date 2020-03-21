package com.thomas.pma.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	//method points out where does the log code to be executed
	//. = classes ..=classes, methods  ..*= classes, methods and everything else
	@Pointcut("within(com.thomas.pma.controllers..*)"
			+ "|| within(com.thomas.pma.dao..*)")
	public void definePackagePointcuts() {
		//empty method just to name the location specified in the pointcut
	}
	
	//method with the code to be run at the pointcut
	@After("definePackagePointcuts()")
	public void log() {
		log.debug(" ------------------------------------------------------ ");
	}
}
