package com.example.repository;

import com.example.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository2 extends JpaRepository<Customer, Long> {

//    @Query(value="select c.* from customer c where c.last_name = :lastname", nativeQuery = true)
//    List<Customer> findByQuery2(String lastname);

    @Query(value="select c from customer c where c.lastName = :lastname")
    List<Customer> findByQuery2(@Param("lastname") String lastname);
}