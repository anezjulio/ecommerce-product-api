package com.tilin.core.product.application.service;

import com.tilin.core.product.application.constants.ApplicationConstant;
import com.tilin.core.product.application.dto.ProductResponseDTO;
import com.tilin.core.product.application.exception.ProductException;
import com.tilin.core.product.domain.models.Product;
import com.tilin.core.product.domain.repository.ProductRepository;
import com.tilin.core.product.insfrastructure.controller.ProductController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LogManager.getLogger(ProductController.class);
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO getProductListResponse() {
        return new ProductResponseDTO(
                ApplicationConstant.STATUS_200,
                ApplicationConstant.MESSAGE_PRODUCT_LISTED_SUCCESFULLY,
                this.getProductList()
        );
    }

    public List<Product> getProductList() {
        List<Product> productList = productRepository.findAll();
        logger.info(ApplicationConstant.MESSAGE_DIVISOR);
        productList.stream().forEach(
                product -> logger.info(product.getName())
        );
        return productList;
    }

    public Product getProductById(String productId) {
        try {
            Optional<Product> optionalProduct = productRepository.findById(Long.parseLong(productId));
            if (optionalProduct.isPresent()) {
                return optionalProduct.get();
            } else {
                logger.info(ApplicationConstant.MESSAGE_ERROR_ID + productId + ApplicationConstant.MESSAGE_NOT_FOUND);
                throw new ProductException(HttpStatus.BAD_REQUEST, "Error finding product with specific id", productId);
            }
        } catch (Exception e){
            throw new ProductException(HttpStatus.BAD_REQUEST, "Error finding product with specific id", productId);
        }

    }

    @Override
    public ProductResponseDTO getProductByIdResponse(String productId) {
        return new ProductResponseDTO(
                ApplicationConstant.STATUS_200,
                ApplicationConstant.MESSAGE_PRODUCT + productId + ApplicationConstant.MESSAGE_FOUND_SUCCESFULLY,
                this.getProductById(productId)
        );
    }

    public List<Product> insertProduct(List<Product> requestProductList) {
        try {
            return productRepository.saveAll(requestProductList);
        } catch (Exception e) {
            logger.info(ApplicationConstant.MESSAGE_ERROR_PRODUCTS_COULDNT_BE_INSERTED);
        }
        return new ArrayList<Product>();
    }

    @Override
    public ProductResponseDTO insertProductResponse(List<Product> requestProductList) {
        return new ProductResponseDTO(
                ApplicationConstant.STATUS_200,
                ApplicationConstant.MESSAGE_PRODUCT_LIST_INSERTED_SUCCESFULLY,
                this.insertProduct(requestProductList)
        );
    }

    public List<Product> modifyProduct(List<Product> requestListProductDTO) {
        try {
            return productRepository.saveAllAndFlush(requestListProductDTO);
        } catch (Exception e) {
            logger.info(ApplicationConstant.MESSAGE_ERROR_PRODUCTS_COULDNT_BE_MODIFIED);
        }
        return new ArrayList<Product>();
    }

    @Override
    public ProductResponseDTO modifyProductResponse(List<Product> requestProductList) {
        return new ProductResponseDTO(
                ApplicationConstant.STATUS_200,
                ApplicationConstant.MESSAGE_PRODUCT_LIST_HAVE_BEEN_MODIFIED_SUCCESFULLY,
                this.modifyProduct(requestProductList)
        );
    }

    public String deleteProduct(Long productId) {
        try {
            productRepository.deleteById(productId);
            return ApplicationConstant.MESSAGE_ID + productId + ApplicationConstant.MESSAGE_HAVE_BEEN_DELETED;
        } catch (Exception e) {
            return ApplicationConstant.MESSAGE_ERROR_ID + productId + ApplicationConstant.MESSAGE_DOESN_T_EXISTS;
        }
    }

    @Override
    public ProductResponseDTO deleteProductResponse(Long productId) {
        return new ProductResponseDTO(
                ApplicationConstant.STATUS_200,
                ApplicationConstant.MESSAGE_PRODUCT + productId + ApplicationConstant.MESSAGE_HAVE_BEEN_DELETED_SUCCESFULLY,
                this.deleteProduct(productId)
        );
    }
}
