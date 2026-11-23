package myspring.di.annotation.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annotation.HelloBean;


/*
 * AnnotationConfigContextLoader 로더 클래스는 
 * 변경된 AnnotationConfigApplicationContext 컨테이너 클래스를 로딩 해주는 역할을 한다. 
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloBeanConfig.class,
	loader = AnnotationConfigContextLoader.class)
public class AnnotatedHelloBeanConfigTest {
	@Autowired
	HelloBean hello;
	
	@Test
	void hello() {
		assertEquals("Hello 어노테이션", hello.sayHello());
	}
}