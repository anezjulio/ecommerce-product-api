package com.tilin.ecommerce.api.product.application.dto;

import com.tilin.ecommerce.api.product.domain.models.Product;

import java.util.List;

public class RequestProductDTO {
    List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}

