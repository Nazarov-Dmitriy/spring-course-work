package ru.netology.coursework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import ru.netology.coursework.loger.Loger;
import ru.netology.coursework.repository.CardRepository;

@SpringBootApplication

public class CourseworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseworkApplication.class, args);
        Loger.write("INFO", "Server starter");
    }

    @Bean
    CommandLineRunner runner(CardRepository cardRepository){
        cardRepository.addCars();
        return null;
    }
}
