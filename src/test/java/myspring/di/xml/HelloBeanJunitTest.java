package myspring.di.xml;

//assertions 클래스에 밑에 있는 모든 메서드를 import 하겠다.

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {
	
	BeanFactory factory;
	
	@BeforeEach
	void container() {
		factory = new GenericXmlApplicationContext("classpath:spring-beans.xml");
		
	}
	
	@Test
	void hello() {
		//1. Bean Container 객체생성
		//2. Hello bean을 Contanier 에게 요청하기
		Hello helloById = (Hello)factory.getBean("hello");
		//2-1. hello Bean을 Container 에게 요청하기 Bean의 id와 type을 기준으로 Bean을 요청하기
		Hello helloByType = factory.getBean("hello", Hello.class);
		
		//2개의 Hello bean의 주소 비교 결과는 True인데 Bean을 두번 생성해도 객체를 한번만 생성해서 재사용할 수 있도록 한다.
		System.out.println(helloById == helloByType);
		//assertSame() 메서드 사용해서 주소 비교
		assertSame(helloById, helloByType);
		
		//setName()의 setter Injection이 제대로 이루어지거 있는지 검증
		assertEquals("Hello 스프링", helloByType.sayHello());
		
		//setPrinter() injection을 검증하기
		helloByType.print();
		
		//3. stringPrinter Bean을 요청하기
		Printer printer = factory.getBean("strPrinter", Printer.class);
		
		assertEquals("Hello 스프링",printer.toString());
		
		
	}

}
