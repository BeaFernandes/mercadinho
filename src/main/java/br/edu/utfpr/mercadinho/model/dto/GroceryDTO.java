package br.edu.utfpr.mercadinho.model.dto;

import br.edu.utfpr.mercadinho.model.domain.Market;
import lombok.*;

import java.util.Date;

@Data
public class GroceryDTO {
    @NonNull
    private Long id;

    @NonNull
    private float total;

    @NonNull
    private Date date;

    @NonNull
    private String market;
}
