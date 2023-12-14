package com.tilin.ecommerce.api.product.insfrastructure.controller;

import com.tilin.ecommerce.api.product.application.dto.ProductResponseDTO;
import com.tilin.ecommerce.api.product.application.dto.RequestProductDTO;
import com.tilin.ecommerce.api.product.application.service.ProductService;
import com.tilin.ecommerce.api.product.insfrastructure.constants.EndpointConstants;
import com.tilin.ecommerce.api.product.insfrastructure.controller.common.AdvisorController;
import com.tilin.ecommerce.api.product.insfrastructure.controller.common.AdvisorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointConstants.Product.BASE_PATH)
public class ProductController extends AdvisorController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = EndpointConstants.Product.LIST_PRODUCT)
    public ResponseEntity<ProductResponseDTO> listProduct() {
        return ResponseEntity.ok(productService.getProductListResponse());
    }

    @GetMapping(value = EndpointConstants.Product.FIND_PRODUCT_BY_PRODUCT_ID)
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable String productId) {
        return ResponseEntity.ok(productService.getProductByIdResponse(productId));
    }

    @PostMapping(value = EndpointConstants.Product.INSERT_PRODUCT)
    public ResponseEntity<ProductResponseDTO> insertProduct(@RequestBody RequestProductDTO requestProductDTO) {
        return ResponseEntity.ok(
                productService.insertProductResponse(
                        requestProductDTO.getProductList()));
    }

    @PostMapping(value = EndpointConstants.Product.MODIFY_PRODUCT)
    public ResponseEntity<ProductResponseDTO> modifyProduct(@RequestBody RequestProductDTO requestProductDTO) {
        return ResponseEntity.ok(
                productService.modifyProductResponse(
                        requestProductDTO.getProductList()));
    }

    @GetMapping(value = EndpointConstants.Product.DELETE_PRODUCT_BY_PRODUCT_ID)
    public ResponseEntity<ProductResponseDTO> deleteProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(
                productService.deleteProductResponse(productId));
    }

}
