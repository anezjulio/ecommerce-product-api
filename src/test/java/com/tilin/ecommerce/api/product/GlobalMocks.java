package com.tilin.ecommerce.api.product;

import com.tilin.ecommerce.api.product.domain.models.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalMocks {

    public static List<Product> get3ProductList() {
        List<Product> productList = new ArrayList<Product>();

        Product product1 = new Product(1L, "empanada de carne", "empanada con carne", 340);
        productList.add(product1);
        Product product2 = new Product(2L, "empanada de pollo", "empanada con pollo", 320);
        productList.add(product2);
        Product product3 = new Product(3L, "empanada de provolone", "empanada con provolone", 400);
        productList.add(product3);

        return productList;
    }

    public static Product getProductToInsert() {
        return new Product(4L, "empanada de pizza", "empanada con pizza", 500);
    }

    public static List<Product> getEmptyProductList() {
        return new ArrayList<Product>();
    }

    public static Product getEmptyProduct() {
        return new Product();
    }

}
