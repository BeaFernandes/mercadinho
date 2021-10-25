package br.edu.utfpr.mercadinho.model.dto;

import br.edu.utfpr.mercadinho.model.domain.Grocery;
import lombok.*;

@Data
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ItemDTO {
    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private float price;

    @NonNull
    private int amount;

    @NonNull
    private float total;

    private Grocery grocery;
}