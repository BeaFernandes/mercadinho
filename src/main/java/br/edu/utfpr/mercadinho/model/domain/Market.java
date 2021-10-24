package br.edu.utfpr.mercadinho.model.domain;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "markets")
@Data(staticConstructor = "of")
@NoArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
}
