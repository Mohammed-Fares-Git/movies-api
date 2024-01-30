package com.mohammedfares.movies_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mohammedfares.movies_api.models.Movie;
import com.mohammedfares.movies_api.servises.MovieServiceImpl;

@SpringBootApplication
public class MoviesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner comandlineRunner(MovieServiceImpl movieServiceImpl) {
		return (e)->{
			movieServiceImpl.insertMovie(new Movie("Elf", "Raised as an oversized elf, Buddy travels from the North Pole to New York City to meet his biological father, Walter Hobbs, who doesn't know he exists and is in desperate need of some Christmas spirit.", 9.99f, "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/53057_500x749.jpg?v=1604088239", "2003"));
			movieServiceImpl.insertMovie(new Movie("Elf", "Raised as an oversized elf, Buddy travels from the North Pole to New York City to meet his biological father, Walter Hobbs, who doesn't know he exists and is in desperate need of some Christmas spirit.", 9.99f, "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/53057_500x749.jpg?v=1604088239", "2003"));
			movieServiceImpl.insertMovie(new Movie("Elf", "Raised as an oversized elf, Buddy travels from the North Pole to New York City to meet his biological father, Walter Hobbs, who doesn't know he exists and is in desperate need of some Christmas spirit.", 9.99f, "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/53057_500x749.jpg?v=1604088239", "2003"));
			movieServiceImpl.insertMovie(new Movie("Elf", "Raised as an oversized elf, Buddy travels from the North Pole to New York City to meet his biological father, Walter Hobbs, who doesn't know he exists and is in desperate need of some Christmas spirit.", 9.99f, "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/53057_500x749.jpg?v=1604088239", "2003"));
			movieServiceImpl.insertMovie(new Movie("Elf", "Raised as an oversized elf, Buddy travels from the North Pole to New York City to meet his biological father, Walter Hobbs, who doesn't know he exists and is in desperate need of some Christmas spirit.", 9.99f, "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/53057_500x749.jpg?v=1604088239", "2003"));
			movieServiceImpl.insertMovie(new Movie("Elf", "Raised as an oversized elf, Buddy travels from the North Pole to New York City to meet his biological father, Walter Hobbs, who doesn't know he exists and is in desperate need of some Christmas spirit.", 9.99f, "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/53057_500x749.jpg?v=1604088239", "2003"));
			movieServiceImpl.insertMovie(new Movie("Elf", "Raised as an oversized elf, Buddy travels from the North Pole to New York City to meet his biological father, Walter Hobbs, who doesn't know he exists and is in desperate need of some Christmas spirit.", 9.99f, "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/53057_500x749.jpg?v=1604088239", "2003"));
		};
		
	}

}
