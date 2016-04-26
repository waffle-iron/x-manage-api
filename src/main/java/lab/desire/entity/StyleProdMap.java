package lab.desire.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by carrot on 2016. 4. 26..
 */
@Data
@Table(name="style_prod_map")
@Entity
public class StyleProdMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne
    @JoinColumn(name="sid")
    Style style;

    @ManyToOne
    @JoinColumn(name="pid")
    Product product;

    public StyleProdMap() {}
}
