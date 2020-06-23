package com.example.customermanagerspringboot.repositories;

import com.example.customermanagerspringboot.models.Customer;
import com.example.customermanagerspringboot.models.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProvinceRepository extends PagingAndSortingRepository<Province,Long> {

}
