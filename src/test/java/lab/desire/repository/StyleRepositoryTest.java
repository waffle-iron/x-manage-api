package lab.desire.repository;

import lab.desire.ManageApplication;
import lab.desire.entity.Style;
import lab.desire.entity.Stylist;
import lab.desire.service.StyleService;
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
public class StyleRepositoryTest {

    @Autowired
    private StyleRepository styleRepository;

    @Autowired
    private StyleService styleService;

    @Test
    public void save() throws Exception {
        Style style = new Style("style name", "no stylist", "#funeral", 100);
        Style p = styleRepository.save(style);
        Assert.notNull(p);
    }

    @Test
    public void saveWithStylist() throws Exception {

        Stylist stylist = new Stylist("한상혁");
        Style style = new Style("style name", "exist stylist", "#wedding", 20000);
        style.setStylist(stylist);

        Style s = styleRepository.save(style);          // CascadeType 활용
        Assert.notNull(s);
    }

    @Test
    public void findById() throws Exception {
        Style p = styleRepository.findById(1L);         // findById !! not findByPid
        System.out.println(p.getName());
        Assert.notNull(p);
    }

    @Test
    public void updateStyle() throws Exception {

        String tag = "new tag";
        String description = "new description";
        int price = 3000;
        Style s = styleService.updateStyle(1L, tag, description, price);
        Assert.notNull(s);

    }

}
