package kr.co.ch05.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAdvice {

	@Pointcut("execution(* kr.co.ch05.sub2.BoardService.insert(..))")
	public void insertPointcut() {}
	@Pointcut("execution(* kr.co.ch05.sub2.BoardService.select(..))")
	public void selectPointcut() {}
	@Pointcut("execution(* kr.co.ch05.sub2.BoardService.update(..))")
	public void updatePointcut() {}
	
	@After("insertPointcut()")
	public void after1() {
		System.out.println("È¾´Ü°ü½É - after1...");
	}
	
	@After("selectPointcut()")
	public void after2() {
		System.out.println("È¾´Ü°ü½É - after2...");
	}
	
	@After("updatePointcut()")
	public void after3() {
		System.out.println("È¾´Ü°ü½É - after3...");
	}
	
}
