package lab.desire.repository;

import lab.desire.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by carrot on 2016. 4. 26..
 */
@Transactional(readOnly = true)
@Repository
public interface StyleRepository extends JpaRepository<Style, String> {

    Style findById(@Param("id") Long id);




}

