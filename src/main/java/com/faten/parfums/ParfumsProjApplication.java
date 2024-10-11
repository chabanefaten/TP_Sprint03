package com.faten.parfums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.faten.parfums.entities.Parfum;
import com.faten.parfums.entities.Role;
import com.faten.parfums.entities.Type;
import com.faten.parfums.entities.User;
import com.faten.parfums.service.ParfumService;
import com.faten.parfums.service.UserService;

import jakarta.annotation.PostConstruct;


@SpringBootApplication
public  class ParfumsProjApplication implements CommandLineRunner{
	@Autowired
	ParfumService parfumService;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ParfumsProjApplication.class, args);
	}
	
	
	/*
	 * @PostConstruct void init_users() { // ajouter les rôles
	 * userService.addRole(new Role(null, "ADMIN")); userService.addRole(new
	 * Role(null, "AGENT")); userService.addRole(new Role(null, "USER")); // ajouter
	 * les users userService.saveUser(new User(null, "admin", "123", true, null));
	 * userService.saveUser(new User(null, "nadhem", "123", true, null));
	 * userService.saveUser(new User(null, "user1", "123", true, null)); // ajouter
	 * les rôles aux users userService.addRoleToUser("admin", "ADMIN");
	 * userService.addRoleToUser("nadhem", "USER");
	 * userService.addRoleToUser("nadhem", "AGENT");
	 * userService.addRoleToUser("user1", "USER"); }
	 */
	
	

	  @Override public void run(String... args) throws Exception {
			/*
			 * System.out.println("Password Encoded BCRYPT :******************** ");
			 * System.out.println(passwordEncoder.encode("123"));
			 */

			/*
			 * parfumService.saveParfum(new Parfum("Black opuim", 2600.0, new Date()));
			 * parfumService.saveParfum(new Parfum("Black XS", 2800.0, new Date()));
			 * parfumService.saveParfum(new Parfum("laurence ", 900.0, new Date()));
			 */
		  repositoryRestConfiguration.exposeIdsFor(Parfum.class,Type.class);
			  }
}
	 
	

