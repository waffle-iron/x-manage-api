package lab.desire.repository;

import lab.desire.ManageApplication;
import lab.desire.entity.Brand;
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
        Product product = new Product("name", "desc", "#tag", 100);
        Product p = productRepository.save(product);
        Assert.notNull(p);
    }

    @Test
    public void saveWithBrand() throws Exception {
//        Brand brand = new Brand("삼디다스");
//        Product product = new Product("name", "desc", "#tag", 100);
//        product.setBrand(brand);

        Brand brand = new Brand("니케");
        Product product = new Product("nike product", "나이키 상품", "#nike #니케", 100);
        product.setBrand(brand);

        Product p = productRepository.save(product);        // CascadeType 활용
        Assert.notNull(p);
    }

    @Test
    public void findById() throws Exception {
        Product p = productRepository.findById(2L);         // findById !! not findByPid
        System.out.println(p.toString());                   // Product 의 ManyToOne 이 LAZY 로딩인 경우는 error 가 나는 게 정상
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
        Product p = em.findProductNamed(1L);                // WHERE p.id !! not WHERE p.pid
        System.out.println(p.toString());
        Assert.notNull(p);
    }

    @Test
    public void updateProduct() throws Exception {

        String tag = "new tag";
        String description = "new description";
        int price = 3000;
        Product p = productService.updateProduct(1L, tag, description, price);
        Assert.notNull(p);

    }

}
