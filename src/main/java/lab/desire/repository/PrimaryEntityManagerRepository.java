package lab.desire.repository;

import lab.desire.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by carrot on 2016. 4. 26..
 */
@Repository
public class PrimaryEntityManagerRepository {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @Transactional
    public Product findProductNamed(Long pid) {
        Product product = (Product) em.createNamedQuery("Product.findProductNamed").setParameter("pid", pid).getSingleResult();
        return product;
    }

}
