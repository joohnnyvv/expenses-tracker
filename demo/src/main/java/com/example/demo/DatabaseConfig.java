package com.example.demo;

import com.example.demo.Categories.CategoryEntity;
import com.example.demo.Categories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Bean
    CommandLineRunner initDatabase(CategoryRepository repository) {
        return args -> {
            repository.save(new CategoryEntity("Bills"));
            repository.save(new CategoryEntity("Groceries"));
            repository.save(new CategoryEntity("Eating Out"));
            repository.save(new CategoryEntity("Entertainment"));
            repository.save(new CategoryEntity("Transport"));
            repository.save(new CategoryEntity("Shopping"));
            repository.save(new CategoryEntity("Health & Fitness"));
            repository.save(new CategoryEntity("Personal Care"));
            repository.save(new CategoryEntity("Housing"));
            repository.save(new CategoryEntity("Insurance"));
            repository.save(new CategoryEntity("Debt Payments"));
            repository.save(new CategoryEntity("Savings & Investments"));
            repository.save(new CategoryEntity("Gifts & Donations"));
            repository.save(new CategoryEntity("Others"));
        };
    }
}
