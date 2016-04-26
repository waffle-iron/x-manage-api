package lab.desire.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by carrot on 2016. 4. 26..
 */

@Data
@Table(name="product_image")
@Entity
public class ProductImage{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pid")
    Product product;

    String path;

    public ProductImage() {}

    public ProductImage(String path) {
        this.path = path;
    }
}
