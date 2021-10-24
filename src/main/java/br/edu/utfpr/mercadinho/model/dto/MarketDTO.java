package br.edu.utfpr.mercadinho.model.dto;

import lombok.*;

@Data
public class MarketDTO {
    @NonNull
    private Long id;

    @NonNull
    private String name;
}
