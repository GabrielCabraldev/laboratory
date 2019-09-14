package br.com.danilomr.mongo.controllers.mappers;

import br.com.danilomr.mongo.controllers.dto.ProductDTO;
import br.com.danilomr.mongo.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static List<ProductDTO> toDTOList(List<Product> productList) {

        return productList.stream()
                .map(productDTO -> toDTO(productDTO))
                .collect(Collectors.toList());
    }

    public static Product toEntity(final ProductDTO productDTO) {

        Product product = new Product();
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());

        return product;
    }

    public static ProductDTO toDTO(final Product product) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.get_id().toString());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());

        return productDTO;
    }
}
