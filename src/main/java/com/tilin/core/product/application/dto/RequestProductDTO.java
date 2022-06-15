package com.tilin.core.product.application.dto;

import com.tilin.core.product.domain.models.Product;

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

