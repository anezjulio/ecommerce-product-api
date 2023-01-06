package com.tilin.core.product.application.service.impl;

import com.tilin.core.product.application.dto.ProductDTO;
import com.tilin.core.product.application.dto.RequestProductDTO;
import com.tilin.core.product.application.exceptions.NoDataFoundException;
import com.tilin.core.product.application.mapper.ProductMapper;
import com.tilin.core.product.application.service.ProductService;
import com.tilin.core.product.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllProduct() throws NoDataFoundException {
        return ProductMapper.mapProductEntityListToProductDTOList(
                productRepository.findAll()
        );
    }

    @Override
    public ProductDTO getProductByProductId(Long productId) throws NoDataFoundException {
        return ProductMapper.mapProductEntityToProductDTO(
                productRepository.findById(productId)
        );
    }

    @Override
    public List<ProductDTO> insertProducts(RequestProductDTO requestProductDTO) throws NoDataFoundException {
        return ProductMapper.mapProductEntityListToProductDTOList(
                productRepository.saveAll(requestProductDTO.getProductList())
        );
    }

    @Override
    public List<ProductDTO> updateProducts(RequestProductDTO requestProductDTO) throws NoDataFoundException {
        return ProductMapper.mapProductEntityListToProductDTOList(
                productRepository.saveAll(requestProductDTO.getProductList())
        );
    }

    @Override
    public void deleteProducts(RequestProductDTO requestProductDTO) {
        productRepository.deleteAll(requestProductDTO.getProductList());
    }

}
