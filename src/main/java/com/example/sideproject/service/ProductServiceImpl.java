package com.example.sideproject.service;

import com.example.sideproject.model.Product;
import com.example.sideproject.repository.IProductRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@NoArgsConstructor
public class ProductServiceImpl implements CrudService<Product, Long> {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private IProductRepository repository;

    @Autowired
    ProductServiceImpl(IProductRepository productRepository) {
        repository = productRepository;
    }

    /**
     * @return List
     */
    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    /**
     * @param id
     * @return Optional
     */
    @Override
    public Product getEntity(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * @param product
     * @return Object
     */
    @Override
    public Product create(Product product) {
        Date date = new Date();
        product.setCreated_at(simpleDateFormat.format(date));

        return repository.save(product);
    }

    /**
     * @param id, product
     * @return Object
     */
    @Override
    @Transactional
    public Product update(Long id, Product product) {
        Date date = new Date();
        product.setUpdated_at(simpleDateFormat.format(date));
        product.setId(id);

        return repository.save(product);
    }

    /**
     * @param id
     */
    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
