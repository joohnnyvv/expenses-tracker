package com.example.demo;

import com.example.demo.Categories.Category;
import com.example.demo.Categories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Bean
    CommandLineRunner initDatabase(CategoryRepository repository) {
        return args -> {
            repository.save(new Category("Bills"));
            repository.save(new Category("Groceries"));
            repository.save(new Category("Eating Out"));
            repository.save(new Category("Entertainment"));
            repository.save(new Category("Transport"));
            repository.save(new Category("Shopping"));
            repository.save(new Category("Health & Fitness"));
            repository.save(new Category("Personal Care"));
            repository.save(new Category("Housing"));
            repository.save(new Category("Insurance"));
            repository.save(new Category("Debt Payments"));
            repository.save(new Category("Savings & Investments"));
            repository.save(new Category("Gifts & Donations"));
            repository.save(new Category("Others"));
        };
    }
}
