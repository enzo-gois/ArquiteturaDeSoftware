package com.projeto.farmacia.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RequestSale(
        String id,

        @NotBlank(message = "O ID do comprador é obrigatório")
        String idCustomer,

        @NotBlank(message = "O ID do produto é obrigatório")
        String idProduct,

        @NotNull
        LocalDateTime saleDate,

        @NotNull
        BigDecimal amountValue
) {
}
