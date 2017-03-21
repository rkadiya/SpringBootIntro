package com.in28minutes.springboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);
	
	@Autowired
	UserRepository repository;

	@Override
	public void run(String... arg0) throws Exception {
		repository.save(new User("Ravi","Admin"));
		repository.save(new User("Divya","User"));
		repository.save(new User("Padma","Admin"));
		repository.save(new User("Srini","User"));
		
		for (User user: repository.findByRole("Admin")) {
			log.info(user.toString());
			
		}
	}
	
}
