package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            //add 2k rows to Author table
            int numRows = 512_000;
//            bookstoreService.populateDatabase(numRows);

            System.out.println("\nStreaming: ");
            bookstoreService.streamDatabase();
            System.out.println("done!");
//            bookstoreService.insert2Postgres();
        };
    }
}
