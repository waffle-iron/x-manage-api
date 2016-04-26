package lab.desire.repository;

import lab.desire.ManageApplication;
import lab.desire.entity.Style;
import lab.desire.entity.StyleImage;
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
public class StyleImageRepositoryTest {

    @Autowired
    private StyleRepository styleRepository;

    @Autowired
    private StyleImageRepository styleImageRepository;

    @Test
    public void save() throws Exception {

        Style style = styleRepository.findById(1L);         // findById !! not findByPid

        StyleImage styleImage = new StyleImage("path2");
        styleImage.setStyle(style);

        StyleImage si = styleImageRepository.save(styleImage);
        Assert.notNull(si);
    }

}
