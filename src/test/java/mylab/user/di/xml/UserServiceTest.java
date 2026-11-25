package mylab.user.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;

import mylab.user.di.annot.UserService;

public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	void testUserService() {
		assertNotNull(userService);
		assertNotNull(userService.getUserRepository());
		assertEquals("MySQL", userService.getUserRepository().getDbType());
		assertNotNull(userService.getSecurityService());
		
		assertTrue(userService.registerUser("A123", "sangmin", "password12"));
		assertFalse(userService.registerUser("A123", "sangmin", null));

	}

}
