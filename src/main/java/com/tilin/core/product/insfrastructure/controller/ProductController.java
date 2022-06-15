package com.tilin.core.product.insfrastructure.controller;

import com.tilin.core.product.application.dto.RequestProductDTO;
import com.tilin.core.product.domain.models.Product;
import com.tilin.core.product.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/core-product/v1")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value="/list-product")
    public ResponseEntity<List<Product>> listProduct(){
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping(value="/find-product/{productId}")
    public ResponseEntity<Optional<Product>> getProduct(
            @PathVariable Long productId
    ){
        return ResponseEntity.ok(productRepository.findById(productId));
    }

    @PostMapping(value ="/insert-product" )
    public ResponseEntity<List<Product>> insertProduct(
            @RequestBody
            RequestProductDTO requestProductDTO
    ){
        List<Product> productList = requestProductDTO.getProductList();
       // for (Product product : productList) {
       //     productRepository.save(product);
        //}
        productRepository.saveAll(productList);
        return ResponseEntity.ok(productList);

    }

}
