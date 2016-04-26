package lab.desire.service;

import lab.desire.entity.Product;
import lab.desire.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by carrot on 2016. 4. 26..
 */

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product updateProduct(Long pid, String tag, String description, int price) {
        Product product = productRepository.findById(pid);
        product.setTag(tag);
        product.setDescription(description);
        product.setPrice(price);
        Product p = productRepository.save(product);

        return p;
    }
}
