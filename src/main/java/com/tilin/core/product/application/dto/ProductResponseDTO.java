package com.tilin.core.product.application.dto;

import com.tilin.core.product.application.dto.common.ResponseEndpointDTO;

public class ProductResponseDTO extends ResponseEndpointDTO {

    public ProductResponseDTO(String status, String message, Object data) {
        super(status, message, data);
    }
}
