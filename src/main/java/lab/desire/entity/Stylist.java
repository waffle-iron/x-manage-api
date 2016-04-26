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
@Entity(name="stylist")
@AttributeOverride(name="id", column = @Column(name="stylist_id"))
public class Stylist extends BaseEntity {

    public Stylist() {}

    public Stylist(String name) {
        this.name = name;
    }
}


