package br.edu.utfpr.mercadinho.model.domain;

import lombok.AccessLevel;
import lombok.*;
import javax.persistence.*;
import java.text.DecimalFormat;

@Entity
@Table(name = "products")
@Data(staticConstructor = "of")
@NoArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Item {
    public Item(String name, float price, int amount, float total, Grocery grocery){
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.total = total;
        this.grocery = grocery;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private float price;

    @NonNull
    private int amount;

    @NonNull
    private float total;

    @ManyToOne
    private Grocery grocery;


    @Transient
    public String getFormatedTotal(){
        return moneyFormat(this.total);
    }

    @Transient
    public String getFormatedPrice(){
        return moneyFormat(this.price);
    }

    @Transient
    public String moneyFormat(float value){
        DecimalFormat df = new DecimalFormat("#.00");
        String valueFormated = df.format(value);
        valueFormated = valueFormated.replace(".", ",");

        return "R$ " + valueFormated;
    }
}
