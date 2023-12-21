package com.anezjm.ecommerce.product.api.application.service;

import com.anezjm.ecommerce.product.api.domain.models.Product;
import com.anezjm.ecommerce.product.api.GlobalMocks;
import com.anezjm.ecommerce.product.api.domain.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    void getProductList() {
        // mock dependency
        when(productRepository.findAll()).thenReturn(GlobalMocks.get3ProductList());

        // test
        List<Product> empList = productService.getProductList();

        // asserts
        assertEquals(3, empList.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void getProductById_isPresent() {
        // constants
        Long productId = 1L;

        // mock dependency
        when(productRepository.findById(productId))
                .thenReturn(Optional.ofNullable(GlobalMocks.get3ProductList().get(0)));

        // test
        Product product = productService.getProductById(String.valueOf(productId));

        // asserts
        assertEquals(1, product.getProductId());
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void getProductById_isNotPresent() {
        // constants
        Long productId = 1L;

        // mock dependency
        when(productRepository.findById(productId))
                .thenReturn(Optional.ofNullable(GlobalMocks.getEmptyProduct()));

        // test
        Product product = productService.getProductById(String.valueOf(productId));

        // asserts
        assertEquals(0, product.getProductId());
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void insertProduct_Success() {
        // mock dependency
        when(productRepository.saveAll(Mockito.any()))
                .thenReturn(GlobalMocks.get3ProductList());

        // test
        List<Product> productList = productService.insertProduct(GlobalMocks.get3ProductList());

        // asserts
        assertEquals(3, productList.size());
        verify(productRepository, times(1)).saveAll(Mockito.any());
    }

    @Test
    void insertProduct_ErrorWhenInsert() {
        // mock dependency
        when(productRepository.saveAll(Mockito.any()))
                .thenReturn(GlobalMocks.getEmptyProductList());

        // test
        List<Product> productList = productService.insertProduct(GlobalMocks.get3ProductList());

        // asserts
        assertEquals(0, productList.size());
        verify(productRepository, times(1)).saveAll(Mockito.any());
    }

    @Test
    void modifyProduct_success() {
        // mock dependency
        when(productRepository.saveAllAndFlush(Mockito.any()))
                .thenReturn(GlobalMocks.getEmptyProductList());

        // test
        List<Product> productList = productService.modifyProduct(GlobalMocks.get3ProductList());

        // asserts
        assertEquals(0, productList.size());
        verify(productRepository, times(1)).saveAllAndFlush(Mockito.any());
    }

    @Test
    void modifyProduct_ErrorWhenModify() {
        // mock dependency
        when(productRepository.saveAllAndFlush(Mockito.any()))
                .thenReturn(GlobalMocks.get3ProductList());

        // test
        List<Product> productList = productService.modifyProduct(GlobalMocks.get3ProductList());

        // asserts
        assertEquals(3, productList.size());
        verify(productRepository, times(1)).saveAllAndFlush(Mockito.any());
    }

    @Test
    void deleteProduct() {
        // constants
        Long productId = 1L;

        // mock dependency
        doNothing().when(productRepository).deleteById(isA(Long.class));

        // test
        String response = productService.deleteProduct(productId);

        // asserts
        assertEquals("id: " + productId + " have been deleted.", response);

        // asserts
        verify(productRepository, times(1)).deleteById(Mockito.anyLong());
    }

}