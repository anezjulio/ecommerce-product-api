package com.tilin.core.product.application.service;

import com.tilin.core.product.domain.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    Product getProductById(Long productId);

    List<Product> insertProduct(List<Product> requestProductList);

    List<Product> modifyProduct(List<Product> requestProductList);

    String deleteProduct(Long productId);

}
