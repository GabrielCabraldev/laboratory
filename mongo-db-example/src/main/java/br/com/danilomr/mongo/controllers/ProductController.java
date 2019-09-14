package br.com.danilomr.mongo.controllers;

import br.com.danilomr.mongo.controllers.dto.ProductDTO;
import br.com.danilomr.mongo.controllers.mappers.ProductMapper;
import br.com.danilomr.mongo.domain.Product;
import br.com.danilomr.mongo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(ProductMapper.toDTOList(productService.findAll()));
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("productId") final String productId) {

        return ResponseEntity.ok(ProductMapper.toDTO(productService.findById(productId)));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody final ProductDTO productDTO) {

        Product product = productService.save(ProductMapper.toEntity(productDTO));

        return ResponseEntity.ok(ProductMapper.toDTO(product));
    }

    @PutMapping(value = "/{productId}")
    public ResponseEntity<ProductDTO> update(@PathVariable("productId") final String productId,
                                             @RequestBody final ProductDTO productDTO) {

        Product product = productService.update(productId, ProductMapper.toEntity(productDTO));
        return ResponseEntity.ok(ProductMapper.toDTO(product));
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("productId") final String productId) {

        productService.delete(productId);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
