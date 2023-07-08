package com.example.sideproject.controller;

import com.example.sideproject.model.Product;
import com.example.sideproject.response.ResponseSuccess;
import com.example.sideproject.service.ProductServiceImpl;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/product")
@NoArgsConstructor
public class ProductController {

    private ProductServiceImpl productService;

    @Autowired
    ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSuccess getAll() {
        List<Product> listProduct = productService.getAll();

        return new ResponseSuccess(HttpStatus.OK.value(), "Success", listProduct);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseSuccess create(@Valid @RequestBody Product product) {
        Product newProduct = productService.create(product);

        return new ResponseSuccess(HttpStatus.CREATED.value(), "Insert success", newProduct);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSuccess update(@PathVariable Long id, @RequestBody Product product) {
        Product productRes = productService.update(id, product);

        return new ResponseSuccess(HttpStatus.OK.value(), "Update success", productRes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSuccess delete(@PathVariable Long id) {
        productService.delete(id);

        return new ResponseSuccess(HttpStatus.OK.value(), "Delete Success");
    }

    @GetMapping("/{id}")
    public ResponseSuccess getByID(@PathVariable Long id) {
        Product product = productService.getEntity(id);

        return new ResponseSuccess(HttpStatus.OK.value(), "Success", product);
    }
}
