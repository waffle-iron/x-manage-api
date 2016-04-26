package lab.desire.service;

import lab.desire.entity.Style;
import lab.desire.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by carrot on 2016. 4. 26..
 */

@Service
@Transactional
public class StyleService {

    @Autowired
    private StyleRepository styleRepository;

    public Style updateStyle(Long styleId, String tag, String description, int price) {
        Style style = styleRepository.findById(styleId);
        style.setTag(tag);
        style.setDescription(description);
        style.setPrice(price);
        Style s = styleRepository.save(style);

        return s;
    }
}
