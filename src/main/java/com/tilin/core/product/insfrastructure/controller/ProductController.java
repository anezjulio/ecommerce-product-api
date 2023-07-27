package com.tilin.core.product.insfrastructure.controller;

import com.tilin.core.product.application.dto.DeleteProductResponseDTO;
import com.tilin.core.product.application.dto.RequestProductDTO;
import com.tilin.core.product.application.service.ProductService;
import com.tilin.core.product.domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core-product/v1")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/list-product")
    public ResponseEntity<List<Product>> listProduct() {
        return ResponseEntity.ok(productService.getProductList());
    }

    @GetMapping(value = "/find-product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @PostMapping(value = "/insert-product")
    public ResponseEntity<List<Product>> insertProduct(@RequestBody RequestProductDTO requestProductDTO) {
        return ResponseEntity.ok(
                productService.insertProduct(
                        requestProductDTO.getProductList()));
    }

    @PostMapping(value = "/modify-product")
    public ResponseEntity<List<Product>> modifyProduct(@RequestBody RequestProductDTO requestProductDTO) {
        return ResponseEntity.ok(
                productService.modifyProduct(
                        requestProductDTO.getProductList()));
    }

    @GetMapping(value = "/delete-product/{productId}")
    public ResponseEntity<DeleteProductResponseDTO> deleteProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(
                new DeleteProductResponseDTO(
                        productService.deleteProduct(productId)));
    }

}
