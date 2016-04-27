package lab.desire.entity;

import lab.desire.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carrot on 2016. 4. 26..
 */

@Data
@Table(name="style")
@Entity
@AttributeOverride(name="id", column = @Column(name="sid"))
public class Style extends BaseEntity {

    String description;
    String tag;
    int price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)       // style 저장할때 편의상 stylist 도 같이 저장하기 위해 cascade 활용
    @JoinColumn(name="stylist_id")
    Stylist stylist;



    @OneToMany(mappedBy = "style")
    List<StyleImage> styleImageList = new ArrayList<StyleImage>();


    public Style() {}

    public Style(String name, String description, String tag, int price) {

        this.name = name;
        this.description = description;
        this.tag = tag;
        this.price = price;
    }
}
