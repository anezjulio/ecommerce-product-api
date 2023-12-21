package com.anezjm.ecommerce.product.api.application.dto;

import com.anezjm.ecommerce.product.api.domain.models.Product;

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

