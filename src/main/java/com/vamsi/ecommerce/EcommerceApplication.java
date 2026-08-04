package com.vamsi.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vamsi.ecommerce.model.Product;
import com.vamsi.ecommerce.repository.ProductRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner seedCatalog(ProductRepository products) {
        return args -> {
            if (products.count() == 0) {
                products.save(new Product(null, "Mechanical Keyboard", "80% layout, hot-swappable switches",
                        new BigDecimal("89.99"), 40));
                products.save(new Product(null, "27\" 4K Monitor", "IPS panel, 60Hz",
                        new BigDecimal("329.00"), 15));
                products.save(new Product(null, "USB-C Dock", "10-port dock with 100W passthrough",
                        new BigDecimal("59.50"), 60));
            }
        };
    }
}
