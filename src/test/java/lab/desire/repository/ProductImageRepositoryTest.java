package lab.desire.repository;

import lab.desire.ManageApplication;
import lab.desire.entity.Product;
import lab.desire.entity.ProductImage;
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
public class ProductImageRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    @Test
    public void save() throws Exception {

        Product product = productRepository.findById(1L);         // findById !! not findByPid

        ProductImage productImage = new ProductImage("path1");
        productImage.setProduct(product);

        ProductImage pi = productImageRepository.save(productImage);
        Assert.notNull(pi);
    }

}
