package com.example.sociallapp;

import com.example.sociallapp.dao.ProfileDao;
import com.example.sociallapp.models.Profile;
import com.example.sociallapp.security.JwtService;
import com.example.sociallapp.security.SecConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SociallappApplication implements CommandLineRunner {

	@Autowired
	JwtService jwtService;


	public static void main(String[] args) {
		SpringApplication.run(SociallappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
