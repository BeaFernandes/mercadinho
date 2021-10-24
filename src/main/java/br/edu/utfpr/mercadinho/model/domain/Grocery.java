package br.edu.utfpr.mercadinho.model.domain;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "groceries")
@Data(staticConstructor = "of")
@NoArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String product;

    @NonNull
    private float price;

    @NonNull
    private int amount;

    @NonNull @Column(name = "total-per-item")
    private float totalPerItem;

    @NonNull
    private float total;

    @ManyToOne
    @NonNull
    private Market market;
}
