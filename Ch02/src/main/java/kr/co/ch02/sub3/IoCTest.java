package kr.co.ch02.sub3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2020/08/31 
 * 이름 : 권기민 
 * 내용 : DI Setter를 이용한 스프링 Ioc 구현
 */

public class IoCTest {

	public static void main(String[] args) {
		
		// Ioc를 Setter DI로 적용할 경우
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		TV lgTV 	 = (TV) ctx.getBean("sub3LgTV");
		TV samsungTV = (TV) ctx.getBean("sub3SamsungTV");
		
		lgTV.power();
		lgTV.chUp();
		lgTV.soundUp();
		
		samsungTV.power();
		samsungTV.chUp();
		samsungTV.soundUp();
		
	
	}
}
