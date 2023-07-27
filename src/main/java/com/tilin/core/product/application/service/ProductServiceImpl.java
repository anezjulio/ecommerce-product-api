package com.tilin.core.product.application.service;

import com.tilin.core.product.domain.models.Product;
import com.tilin.core.product.domain.repository.ProductRepository;
import com.tilin.core.product.insfrastructure.controller.ProductController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProductList() {
        List<Product> productList = productRepository.findAll();
        logger.info("---------------------------------------------");
        productList.stream().forEach(
                product -> logger.info(product.getName())
        );
        return productList;
    }

    public Product getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            logger.info("Error, id: " + productId + " not found.");
            return new Product();
        }
    }

    public List<Product> insertProduct(List<Product> requestProductList) {
        try{
            return productRepository.saveAll(requestProductList);
        } catch (Exception e){
            logger.info("Error, the list of products couldn't be inserted.");
        }
        return new ArrayList<Product>();
    }

    public List<Product> modifyProduct(List<Product> requestListProductDTO) {
        try{
            return productRepository.saveAllAndFlush(requestListProductDTO);
        } catch (Exception e){
            logger.info("Error, the list of products couldn't be modified.");
        }
        return new ArrayList<Product>();
    }

    public String deleteProduct(Long productId) {
        try{
            productRepository.deleteById(productId);
            return "id: " + productId + " has been deleted.";
        } catch (Exception e){
            return "Error, id: " + productId + " doesn't exists.";
        }
    }
}
