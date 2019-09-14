package br.com.danilomr.mongo.service;

import br.com.danilomr.mongo.domain.Product;

import java.util.List;

public interface ProductService {

    Product save(final Product product);

    Product update(final String id, final Product product);

    void delete(final String id);

    Product findById(final String id);

    List<Product> findAll();
}
