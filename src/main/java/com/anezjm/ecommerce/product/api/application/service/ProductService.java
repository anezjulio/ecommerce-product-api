package com.anezjm.ecommerce.product.api.application.service;

import com.anezjm.ecommerce.product.api.application.dto.ProductResponseDTO;
import com.anezjm.ecommerce.product.api.domain.models.Product;

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
