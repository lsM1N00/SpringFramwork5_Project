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
	
	@Autowired
	@Qualifier("helloCons")
	Hello hello2;
	
	@Resource(name = "helloCons")
	Hello hello3;
	
	@Test
	void helloBean() {
		assertEquals("Hello 스프링", hello.sayHello());
		
		assertEquals("Hello 생성자", hello2.sayHello());
	}
	
}
