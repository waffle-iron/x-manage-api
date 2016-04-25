package com.example;

import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController public class HelloController {

    @Autowired
    CustomerService customerService;

    @Autowired
    PagingAndSortingRepository<Customer, Long> pageRepository;


    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!!";
    }

    @RequestMapping("find")
    @ResponseBody
    public Customer find(@RequestParam Long id) {
        return customerService.find(id);
    }

    @RequestMapping("findAll")
    public @ResponseBody List<Customer> findAll() {
        List<Customer> result = customerService.findAll();
        return result;
    }

    @RequestMapping("page")
    public @ResponseBody Page<Customer> page(Pageable pageable) {
        Page<Customer> customer = pageRepository.findAll(pageable);

        for (Customer customer1:customer) {
            System.out.println(customer1);
        }
        return customer;
    }

}