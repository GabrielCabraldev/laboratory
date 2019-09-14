package br.com.danilomr.mongo.repositories;

import br.com.danilomr.mongo.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    List<Product> findAll();
}
