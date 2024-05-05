package com.faten.parfums;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import com.faten.parfums.service.ParfumService;


@SpringBootApplication
public  class ParfumsProjApplication implements CommandLineRunner{
	@Autowired
	ParfumService parfumService;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ParfumsProjApplication.class, args);
	}

	  @Override public void run(String... args) throws Exception {
			
			/*
			 * parfumService.saveParfum(new Parfum("Black opuim", 2600.0, new Date()));
			 * parfumService.saveParfum(new Parfum("Black XS", 2800.0, new Date()));
			 * parfumService.saveParfum(new Parfum("laurence ", 900.0, new Date()));
			 */
			  }
}
	 
	

