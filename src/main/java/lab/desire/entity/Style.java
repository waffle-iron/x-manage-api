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
@Entity(name="style")
@AttributeOverride(name="id", column = @Column(name="sid"))
public class Style extends BaseEntity {

    private int stylistId;
    private String description;

    private String tag;
    private int price;

    public Style() {}

}
