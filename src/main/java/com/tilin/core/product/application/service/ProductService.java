package com.tilin.core.product.application.service;

import com.tilin.core.product.application.dto.ProductResponseDTO;
import com.tilin.core.product.domain.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    ProductResponseDTO getProductListResponse();

    Product getProductById(Long productId);

    ProductResponseDTO getProductByIdResponse(Long productId);

    List<Product> insertProduct(List<Product> requestProductList);

    ProductResponseDTO insertProductResponse(List<Product> requestProductList);

    List<Product> modifyProduct(List<Product> requestProductList);

    ProductResponseDTO modifyProductResponse(List<Product> requestProductList);

    String deleteProduct(Long productId);

    ProductResponseDTO deleteProductResponse(Long productId);

}
