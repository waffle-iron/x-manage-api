package lab.desire.entity;

import lab.desire.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by carrot on 2016. 4. 26..
 */

@Data
@Table(name="brand")
@Entity
@AttributeOverride(name="id", column = @Column(name="brand_id"))
public class Brand extends BaseEntity {

    public Brand() {}

    // #issue16 fix again

    public Brand(String name) {
        this.name = name;
    }
}
