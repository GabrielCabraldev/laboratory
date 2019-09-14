package br.com.danilomr.mongo.service;

import br.com.danilomr.mongo.domain.Product;
import br.com.danilomr.mongo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        product.set_id(null);
        return productRepository.save(product);
    }

    @Override
    public Product update(String id, Product product) {

        Product oldProduct = findById(id);
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        return productRepository.save(oldProduct);
    }

    @Override
    public void delete(String id) {
        Product product = findById(id);
        productRepository.delete(product);
    }

    @Override
    public Product findById(String id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
