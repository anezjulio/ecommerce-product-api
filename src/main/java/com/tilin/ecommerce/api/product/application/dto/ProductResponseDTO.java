package com.tilin.ecommerce.api.product.application.dto;

import com.tilin.ecommerce.api.product.application.dto.common.ResponseEndpointDTO;
import com.tilin.ecommerce.api.product.application.dto.common.ResponseEndpointDTO;

public class ProductResponseDTO extends ResponseEndpointDTO {

    public ProductResponseDTO(String status, String message, Object data) {
        super(status, message, data);
    }
}
