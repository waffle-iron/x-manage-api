package lab.desire.entity.base;

import lab.desire.common.DesireConstant;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by carrot on 2016. 4. 26..
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;
    protected String regdttm;
    protected String upddttm;

    @PrePersist
    public void setRegdttm() {
        regdttm = DesireConstant.sdf.format(new Date());
        setUpddttm();
    }


    @PreUpdate
    public void setUpddttm() {
        upddttm = DesireConstant.sdf.format(new Date());
    }

}
