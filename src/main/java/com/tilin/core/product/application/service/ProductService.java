package com.tilin.core.product.application.service;

import com.tilin.core.product.application.dto.ProductResponseDTO;
import com.tilin.core.product.domain.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();
    Product getProductById(String productId);
    List<Product> insertProduct(List<Product> requestProductList);
    List<Product> modifyProduct(List<Product> requestProductList);
    String deleteProduct(Long productId);

    ProductResponseDTO getProductListResponse();
    ProductResponseDTO getProductByIdResponse(String productId);
    ProductResponseDTO insertProductResponse(List<Product> requestProductList);
    ProductResponseDTO modifyProductResponse(List<Product> requestProductList);
    ProductResponseDTO deleteProductResponse(Long productId);

}
