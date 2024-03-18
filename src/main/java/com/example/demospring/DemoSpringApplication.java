package com.example.demospring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class DemoSpringApplication implements CommandLineRunner {

	// @Autowired
	// private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// String sql = "INSERT INTO users (id, username, email) VALUES ("
		// 		+ "'5','admin5' , 'admin5@gmail.com')";

		// int rows = jdbcTemplate.update(sql);
		// if (rows > 0) {
		// 	System.out.println("A new row has been inserted.");
		// }
	}

}
