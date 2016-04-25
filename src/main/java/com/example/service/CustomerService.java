package com.example.service;

/**
 * Created by carrot on 2016. 4. 6..
 */
import com.example.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.CustomerRepository;
import com.example.repository.CustomerRepository2;

import java.util.List;

/**
 * product, style 모두 관리하는 service 라 해두자
 *
 * Created by unong on 4/6/16.
 */
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerRepository2 customerRepository2;


//    public void upload(String sid, String description, String url) {
//        customerRepository.save(new Style(sid, description, url));
//    }
//
//    public void update(String sid, String description, String url) {
//        customerRepository.save(new Style(sid, description, url));
//    }

    public List<Customer> find(String name) {
        return customerRepository.findByLastName(name);
    }

    public Customer find(Long id) {
        return customerRepository2.findOne(id);
    }

    public List<Customer> findAll() {
        return customerRepository2.findAll();
    }

}