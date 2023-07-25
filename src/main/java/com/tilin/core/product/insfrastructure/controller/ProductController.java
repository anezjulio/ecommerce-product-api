package com.tilin.core.product.insfrastructure.controller;

import com.tilin.core.product.application.dto.DeleteProductResponseDTO;
import com.tilin.core.product.application.dto.RequestProductDTO;
import com.tilin.core.product.domain.models.Product;
import com.tilin.core.product.domain.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/core-product/v1")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/list-product")
    public ResponseEntity<List<Product>> listProduct() {
        List<Product> productList = productRepository.findAll();
        logger.info("---------------------------------------------");
        productList.stream().forEach(
                product -> logger.info(product.getName())
        );
        return ResponseEntity.ok(productList);
    }

    @GetMapping(value = "/find-product/{productId}")
    public ResponseEntity<Optional<Product>> getProduct(
            @PathVariable Long productId
    ) {
        return ResponseEntity.ok(productRepository.findById(productId));
    }

    @PostMapping(value = "/insert-product")
    public ResponseEntity<List<Product>> insertProduct(
            @RequestBody
            RequestProductDTO requestProductDTO
    ) {
        List<Product> productList = requestProductDTO.getProductList();
        productRepository.saveAll(productList);
        return ResponseEntity.ok(productList);

    }

    @PostMapping(value = "/modify-product")
    public ResponseEntity<List<Product>> modifyProduct(
            @RequestBody  RequestProductDTO requestProductDTO
    ) {
        return ResponseEntity.ok(productRepository.saveAllAndFlush(requestProductDTO.getProductList()));
    }

    @GetMapping(value = "/delete-product/{productId}")
    public ResponseEntity<DeleteProductResponseDTO>deleteProduct(
            @PathVariable Long productId
    ) {
        productRepository.deleteById(productId);
        return ResponseEntity.ok(new DeleteProductResponseDTO("id: " + productId + " has been deleted."));
    }

}
