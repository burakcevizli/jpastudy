package com.burakexample.jpa;

import com.burakexample.jpa.models.Author;
import com.burakexample.jpa.models.Video;
import com.burakexample.jpa.repositories.AuthorRepository;
import com.burakexample.jpa.repositories.VideoRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository authorRepository, VideoRepository videoRepository){
		return  args -> {
			Faker faker = new Faker();
			/*for(int i = 0; i< 50; i++){
				var author = Author.builder().firstName(faker.name().firstName()).lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19,50)).email("burak"+ i +"cevizli@gmail.com").build();
				authorRepository.save(author);
			}*/


			/*var video = Video.builder().name("abn").length(5).build();
			videoRepository.save(video);*/

			//authorRepository.updateAuthor(22,1);
			//authorRepository.updateAllAuthorsAges(99);
			authorRepository.findByNamedQuery(60).forEach(System.out::println);

		};

	}
}
