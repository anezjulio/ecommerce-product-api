package com.tilin.core.product.application.service;

import com.tilin.core.product.application.dto.ProductResponseDTO;
import com.tilin.core.product.domain.models.Product;
import com.tilin.core.product.domain.repository.ProductRepository;
import com.tilin.core.product.insfrastructure.controller.ProductController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LogManager.getLogger(ProductController.class);

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductResponseDTO getProductListResponse() {
        return new ProductResponseDTO(
                "200",
                "Product listed succesfully",
                this.getProductList()
        );
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

    @Override
    public ProductResponseDTO getProductByIdResponse(Long productId) {
        return new ProductResponseDTO(
                "200",
                "Product "+productId+" found succesfully",
                this.getProductById(productId)
        );
    }

    public List<Product> insertProduct(List<Product> requestProductList) {
        try{
            return productRepository.saveAll(requestProductList);
        } catch (Exception e){
            logger.info("Error, the list of products couldn't be inserted.");
        }
        return new ArrayList<Product>();
    }

    @Override
    public ProductResponseDTO insertProductResponse(List<Product> requestProductList) {
        return new ProductResponseDTO(
                "200",
                "Product list inserted succesfully",
                this.insertProduct(requestProductList)
        );
    }

    public List<Product> modifyProduct(List<Product> requestListProductDTO) {
        try{
            return productRepository.saveAllAndFlush(requestListProductDTO);
        } catch (Exception e){
            logger.info("Error, the list of products couldn't be modified.");
        }
        return new ArrayList<Product>();
    }

    @Override
    public ProductResponseDTO modifyProductResponse(List<Product> requestProductList) {
        return new ProductResponseDTO(
                "200",
                "Product list have been modified succesfully",
                this.modifyProduct(requestProductList)
        );
    }

    public String deleteProduct(Long productId) {
        try{
            productRepository.deleteById(productId);
            return "id: " + productId + " has been deleted.";
        } catch (Exception e){
            return "Error, id: " + productId + " doesn't exists.";
        }
    }

    @Override
    public ProductResponseDTO deleteProductResponse(Long productId) {
        return new ProductResponseDTO(
                "200",
                "Product " +productId+" have been deleted succesfully",
                this.deleteProduct(productId)
        );
    }
}
