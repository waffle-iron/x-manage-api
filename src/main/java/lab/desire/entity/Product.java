package lab.desire.entity;

import lab.desire.entity.base.BaseEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;


/**
 * Created by carrot on 2016. 4. 26..
 */

@Data
@ToString
@Entity
@AttributeOverride(name="id", column = @Column(name="pid"))
public class Product extends BaseEntity {

    Integer brandId;

    String description;
    String tag;
    int price;

    public Product() {}

    public Product(String name, Integer brandId, String description, String tag, int price) {

        this.name = name;
        this.brandId = brandId;
        this.description = description;
        this.tag = tag;
        this.price = price;
    }

}
