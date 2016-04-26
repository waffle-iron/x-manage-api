package lab.desire.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by carrot on 2016. 4. 26..
 */

@Data
@Table(name="style_image")
@Entity
public class StyleImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sid")
    Style style;

    String path;

    public StyleImage() {}

    public StyleImage(String path) {
        this.path = path;
    }
}
