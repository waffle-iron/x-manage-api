package lab.desire.repository;

import lab.desire.ManageApplication;
import lab.desire.entity.Product;
import lab.desire.service.ProductService;
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
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    PrimaryEntityManagerRepository em;

    @Autowired
    private ProductService productService;

    @Test
    public void save() throws Exception {
        Product product = new Product("name", 1, "desc", "#tag", 100);
        Product p = productRepository.save(product);
        Assert.notNull(p);
    }

    @Test
    public void findById() throws Exception {
        Product p = productRepository.findById(1L);         // findById !! not findByPid
        System.out.println(p.toString());
        Assert.notNull(p);
    }

    @Test
    public void findProductNamed() throws Exception {
        Product p = productRepository.findProductNamed(1L); // Sping Data JPA 에서는 method 이름만으로 Named 쿼리를 호출할 수 있다
        System.out.println(p.toString());
        Assert.notNull(p);
    }

    @Test
    public void findByEm() throws Exception {
        Product p = em.findProductNamed(1L);           // WHERE p.id !! not WHERE p.pid
        System.out.println(p.toString());
        Assert.notNull(p);
    }

    @Test
    public void updateProduct() throws Exception {

        String tag = "new tag";
        String description = "new description";
        int price = 3000;
        productService.updateProduct(tag, description, price);


    }

}
