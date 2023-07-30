package com.tilin.core.product.insfrastructure.controller;

import com.tilin.core.product.application.dto.DeleteProductResponseDTO;
import com.tilin.core.product.application.dto.ProductResponseDTO;
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
    public ResponseEntity<ProductResponseDTO> listProduct() {
        return ResponseEntity.ok(productService.getProductListResponse());
    }

    @GetMapping(value = "/find-product/{productId}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductByIdResponse(productId));
    }

    @PostMapping(value = "/insert-product")
    public ResponseEntity<ProductResponseDTO> insertProduct(@RequestBody RequestProductDTO requestProductDTO) {
        return ResponseEntity.ok(
                productService.insertProductResponse(
                        requestProductDTO.getProductList()));
    }

    @PostMapping(value = "/modify-product")
    public ResponseEntity<ProductResponseDTO> modifyProduct(@RequestBody RequestProductDTO requestProductDTO) {
        return ResponseEntity.ok(
                productService.modifyProductResponse(
                        requestProductDTO.getProductList()));
    }

    @GetMapping(value = "/delete-product/{productId}")
    public ResponseEntity<ProductResponseDTO> deleteProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(
                        productService.deleteProductResponse(productId));
    }

}
