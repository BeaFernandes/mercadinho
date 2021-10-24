package br.edu.utfpr.mercadinho.model.dto;

import br.edu.utfpr.mercadinho.model.domain.Market;
import lombok.*;

@Data
public class GroceryDTO {
    @NonNull
    private String product;

    @NonNull
    private float price;

    @NonNull
    private int amount;

    @NonNull
    private float totalPerItem;

    @NonNull
    private float total;

    @NonNull
    private Market market;
}
