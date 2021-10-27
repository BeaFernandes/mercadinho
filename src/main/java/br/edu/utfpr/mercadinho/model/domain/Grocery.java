package br.edu.utfpr.mercadinho.model.domain;

import lombok.*;
import javax.persistence.*;
import java.text.DecimalFormat;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private float total;

    @NonNull
    private Date date;

    @NonNull
    private String market;

    @Transient
    public String getFormatedDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String date = sdf.format(this.date);
        return date;
    }

    @Transient
    public String getFormatedTotal(){
        DecimalFormat df = new DecimalFormat("#.00");
        String total = df.format(this.total);
        total = total.replace(".", ",");

        return "R$ " + total;
    }
}
