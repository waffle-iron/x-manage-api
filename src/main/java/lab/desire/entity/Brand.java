package lab.desire.entity;

import lab.desire.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by carrot on 2016. 4. 26..
 */

@Data
@Entity(name="brand")
@AttributeOverride(name="id", column = @Column(name="brand_id"))
public class Brand extends BaseEntity {

    public Brand() {}

    public Brand(String name) {
        this.name = name;
    }
}
