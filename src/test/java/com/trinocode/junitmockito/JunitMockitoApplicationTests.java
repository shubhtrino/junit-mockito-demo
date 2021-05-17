package com.trinocode.junitmockito;

import com.trinocode.junitmockito.model.User;
import com.trinocode.junitmockito.repository.UserRepository;
import com.trinocode.junitmockito.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class JunitMockitoApplicationTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	void findAllTest(){
		when(userRepository.findAll()).thenReturn(Stream.of(new User(1,"abc","a.com"),new User(2,"pqr","pqr.com")).collect(Collectors.toList()));
		assertEquals(2,userService.findAll().size());
	}

	@Test
	void findByUserNameTest(){
		String userName="abc";
		when(userService.findByUsreName(userName)).thenReturn(Stream.of(new User(1,"asd","asd")).collect(Collectors.toList()));
		assertEquals(1,userService.findByUsreName(userName).size());
	}

	@Test
	void saveUserTest(){
		User user = new User(1,"zzz","zzz");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user,userService.saveUser(user));
	}

	@Test
	void deleteUserTest(){
		User user = new User(1,"zzz","zzz");
		userService.deleteUser(user);
		verify(userRepository,times(1)).delete(user);
	}

	

}
