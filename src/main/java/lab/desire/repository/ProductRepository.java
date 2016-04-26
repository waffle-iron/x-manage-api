package lab.desire.repository;

import lab.desire.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by carrot on 2016. 4. 26..
 */
//@Transactional(readOnly = true)
//@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Product findById(@Param("id") Long id);

    Product findProductNamed(@Param("pid") Long pid);

}

