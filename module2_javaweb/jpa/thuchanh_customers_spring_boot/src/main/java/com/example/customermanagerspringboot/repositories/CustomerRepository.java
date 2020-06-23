package com.example.customermanagerspringboot.repositories;

import com.example.customermanagerspringboot.models.Customer;
import com.example.customermanagerspringboot.models.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

@EnableJpaRepositories
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
List<Customer> findAllByProvince(Province province);
Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
