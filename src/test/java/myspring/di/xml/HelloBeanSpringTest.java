package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	Hello hello; // 이거랑 동일 Hello helloByType = factory.getBean("hello", Hello.class);
	
	//@Autowired - Bean의 Class Type으로 의존하는 객체를 찾는 방
	@Autowired
	@Qualifier("helloCons")
	Hello hello2;
	
	//@Resource - Bean의 name(id)값으로 의존하는 객체를 찾는 방법
	@Resource(name = "helloCons")
	Hello hello3;
	
	@Test
	void helloBean() {
		assertEquals("Hello 스프링", hello.sayHello());
		
		assertEquals("Hello 생성자", hello2.sayHello());
		
		assertEquals("Hello 생성자", hello3.sayHello());
		
		hello2.print();
	}
	
}
