package com.example;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.repository.CustomerRepository2;
import com.example.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class DemoApplicationTests {
	@Autowired
	CustomerService customerService;

	@Autowired
	PagingAndSortingRepository<Customer, Long> pageRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerRepository2 customerRepository2;


	//	@Test
	public void test1() {
		Customer customer = customerService.find((long)3);

		System.out.println(customer);
	}

	@Test
	public void pageTest() {
//		Page<Customer> customer = pageRepository.findAll(new PageRequest(1, 3));

//		List<Customer> customer = customerRepository.findByLastNameAndFirstName("Bauer","Kim");

//		List<Customer> customer = customerRepository.findByLastNameLike("Bau");
//		List<Customer> customer = customerRepository.findByQuery("Bau");
		List<Customer> customer = customerRepository2.findByQuery2("Bauer");

		for (Customer customer1:customer) {
			System.out.println(customer1);
		}

	}
}
