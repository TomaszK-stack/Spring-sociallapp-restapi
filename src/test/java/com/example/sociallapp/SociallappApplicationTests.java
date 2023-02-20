package com.example.sociallapp;

import com.example.sociallapp.dao.UserDao;
import com.example.sociallapp.models.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;


@SpringBootTest
class SociallappApplicationTests {

//	@Autowired
//	MockMvc mockMvc;

	@Autowired
	UserDao userDao;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Test
	void contextLoads() {

		Optional<Users> us = Optional.ofNullable(userDao.findByEmail("tk20@onet.com").orElse(null));
		Users user = us.get();
		assertEquals(1, user.getId());

	}

	@Test
	void testpassword(){
		System.out.println(passwordEncoder.encode("ab"));


	}

}
