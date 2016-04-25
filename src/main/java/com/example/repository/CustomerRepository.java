package com.example.repository;

import com.example.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    List<Customer> findByLastNameAndFirstName(String lastName, String firstName);



    List<Customer> findByLastNameLike(String lastName);
}