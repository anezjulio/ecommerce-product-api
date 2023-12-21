package com.anezjm.ecommerce.product.api.application.dto;

import com.anezjm.ecommerce.product.api.application.dto.common.ResponseEndpointDTO;

public class ProductResponseDTO extends ResponseEndpointDTO {

    public ProductResponseDTO(String status, String message, Object data) {
        super(status, message, data);
    }
}
