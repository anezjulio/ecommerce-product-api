package com.tilin.core.product.insfrastructure.controller;

import com.tilin.core.product.application.dto.ProductDTO;
import com.tilin.core.product.application.dto.RequestProductDTO;
import com.tilin.core.product.application.exceptions.NoDataFoundException;
import com.tilin.core.product.application.service.ProductService;
import com.tilin.core.product.domain.constants.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApplicationConstants.CORE_PRODUCT_BASE_ENDPOINT)
public class ProductController {

    private final ProductService productService;

    @Autowired
    private ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = ApplicationConstants.CORE_PRODUCT_PRODUCT_LIST_ENDPOINT)
    public ResponseEntity<List<ProductDTO>> listProduct() throws NoDataFoundException {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping(value = ApplicationConstants.CORE_PRODUCT_FIND_PRODUCT_ENDPOINT)
    public ResponseEntity<ProductDTO> getProduct(
            @PathVariable Long productId) throws NoDataFoundException {
        return ResponseEntity.ok(productService.getProductByProductId(productId));
    }

    @PostMapping(value = ApplicationConstants.CORE_PRODUCT_INSERT_PRODUCT_ENDPOINT)
    public ResponseEntity<List<ProductDTO>> insertProduct(
            @RequestBody RequestProductDTO requestProductDTO) throws NoDataFoundException {
        return ResponseEntity.ok(productService.insertProducts(requestProductDTO));
    }

    @PutMapping(value = ApplicationConstants.CORE_PRODUCT_UPDATE_PRODUCT_ENDPOINT)
    public ResponseEntity<List<ProductDTO>> updateProduct(
            @RequestBody RequestProductDTO requestProductDTO) throws NoDataFoundException {
        return ResponseEntity.ok(productService.updateProducts(requestProductDTO));
    }

    @PutMapping(value = ApplicationConstants.CORE_PRODUCT_DELETE_PRODUCT_ENDPOINT)
    public ResponseEntity<List<ProductDTO>> deleteProduct(
            @RequestBody RequestProductDTO requestProductDTO) throws NoDataFoundException {
        return ResponseEntity.ok(productService.updateProducts(requestProductDTO));
    }

}
