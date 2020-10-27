package kr.co.ch05.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturnAdvice {
	
	@Pointcut("execution(* kr.co.ch05.sub2.BoardService.insert(..))")
	public void insertPointcut() {}
	@Pointcut("execution(* kr.co.ch05.sub2.BoardService.select(..))")
	public void selectPointcut() {}
	@Pointcut("execution(* kr.co.ch05.sub2.BoardService.update(..))")
	public void updatePointcut() {}

	
	@AfterReturning("insertPointcut()")
	public void afterReturn1() {
		System.out.println("È¾´Ü°ü½É - afterReturn1...");
	}
	
	@AfterReturning("selectPointcut()")
	public void afterReturn2() {
		System.out.println("È¾´Ü°ü½É - afterReturn2...");
	}
	
	@AfterReturning("updatePointcut()")
	public void afterReturn3() {
		System.out.println("È¾´Ü°ü½É - afterReturn3...");
	}
}
