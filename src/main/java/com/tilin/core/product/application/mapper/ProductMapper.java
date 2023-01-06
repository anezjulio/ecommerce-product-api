package com.tilin.core.product.application.mapper;

import com.tilin.core.product.application.dto.ProductDTO;
import com.tilin.core.product.application.exceptions.NoDataFoundException;
import com.tilin.core.product.domain.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductMapper {

    public static ProductDTO mapProductEntityToProductDTO(Optional<Product> product) throws NoDataFoundException {
        if (!product.isPresent()) { throw new NoDataFoundException(); }
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.get().getName());
        productDTO.setDescription(product.get().getDescription());
        productDTO.setPrice(String.valueOf(product.get().getPrice()));
        return productDTO;
    }

    public static List<ProductDTO> mapProductEntityListToProductDTOList(List<Product> productList) throws NoDataFoundException {
        if (productList.size() < 1) { throw new NoDataFoundException(); }
        try {
            List<ProductDTO> productDTOList = new ArrayList<>();
            for (Product product : productList) {
                productDTOList.add(ProductMapper.mapProductEntityToProductDTO(Optional.ofNullable(product)));
            }
            return productDTOList;
        } catch (Exception e) {
            throw new NoDataFoundException();
        }
    }
}
