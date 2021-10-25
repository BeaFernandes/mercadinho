package br.edu.utfpr.mercadinho.model.domain;

import lombok.*;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

@Entity
@Table(name = "groceries")
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Grocery {

    public Grocery(float total, String market) {
        this.total = total;
        this.market = market;
    }

    public Grocery(float total, String date, String market, List<Item> items) {
        this.total = total;
        this.date = date;
        this.market = market;
        this.items = items;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private float total;

    @NonNull
    private String date;

    @NonNull
    private String market;


    @Transient
    private List<Item> items;
}
