package lab.desire.repository;

import lab.desire.ManageApplication;
import lab.desire.entity.Product;
import lab.desire.entity.Style;
import lab.desire.entity.StyleProdMap;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

/**
 * Created by carrot on 2016. 4. 26..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ManageApplication.class)
@WebAppConfiguration
@Slf4j
public class StyleProdMapRepositoryTest {

    @Autowired
    private StyleRepository styleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StyleProdMapRepository styleProdMapRepository;

    @Test
    public void save() throws Exception {

        Style style = styleRepository.findById(2L);         // findById !! not findByPid

        Product p1 = productRepository.findById(3L);
        Product p2 = productRepository.findById(4L);

        StyleProdMap styleProdMap = new StyleProdMap();
        styleProdMap.setStyle(style);

        styleProdMap.setProduct(p1);
        styleProdMapRepository.save(styleProdMap);

        StyleProdMap styleProdMap2 = new StyleProdMap();
        styleProdMap2.setStyle(style);
        styleProdMap2.setProduct(p2);
        styleProdMapRepository.save(styleProdMap2);

        Assert.notNull(style);
    }

}
