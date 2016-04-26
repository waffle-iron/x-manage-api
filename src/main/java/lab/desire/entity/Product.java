package lab.desire.entity;

import lab.desire.entity.base.BaseEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


/**
 * Created by carrot on 2016. 4. 26..
 */

@Data
@ToString
@Entity
@AttributeOverride(name="id", column = @Column(name="pid"))
public class Product extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)       // product 저장할때 편의상 brand 도 같이 저장하기 위해 cascade 활용
    @JoinColumn(name="brand_id")
    private Brand brand;

    String description;
    String tag;
    int price;

    public Product() {}

    public Product(String name, String description, String tag, int price) {

        this.name = name;
        this.description = description;
        this.tag = tag;
        this.price = price;
    }

}
