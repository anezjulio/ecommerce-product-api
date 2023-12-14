package com.tilin.ecommerce.api.product.domain.repository;

import com.tilin.ecommerce.api.product.domain.models.Product;
import com.tilin.ecommerce.api.product.domain.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
