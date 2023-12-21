package com.anezjm.ecommerce.product.api.domain.repository;

import com.anezjm.ecommerce.product.api.domain.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
