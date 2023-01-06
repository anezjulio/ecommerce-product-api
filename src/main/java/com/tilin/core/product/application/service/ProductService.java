package com.tilin.core.product.application.service;

import com.tilin.core.product.application.dto.ProductDTO;
import com.tilin.core.product.application.dto.RequestProductDTO;
import com.tilin.core.product.application.exceptions.NoDataFoundException;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProduct() throws NoDataFoundException;
    ProductDTO getProductByProductId(Long productId) throws NoDataFoundException;
    List<ProductDTO> insertProducts(RequestProductDTO requestProductDTO) throws NoDataFoundException;
    List<ProductDTO> updateProducts(RequestProductDTO requestProductDTO) throws NoDataFoundException;
    void deleteProducts(RequestProductDTO requestProductDTO) throws NoDataFoundException;
}
