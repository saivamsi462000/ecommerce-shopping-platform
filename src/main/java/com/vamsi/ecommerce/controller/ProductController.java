package com.vamsi.ecommerce.controller;

import com.vamsi.ecommerce.model.Product;
import com.vamsi.ecommerce.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository products;

    public ProductController(ProductRepository products) {
        this.products = products;
    }

    @GetMapping
    public List<Product> findAll() {
        return products.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findOne(@PathVariable Long id) {
        return products.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        Product saved = products.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!products.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        products.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
