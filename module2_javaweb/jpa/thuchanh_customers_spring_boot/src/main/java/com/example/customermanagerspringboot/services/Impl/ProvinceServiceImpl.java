package com.example.customermanagerspringboot.services.Impl;

import com.example.customermanagerspringboot.models.Province;
import com.example.customermanagerspringboot.repositories.ProvinceRepository;
import com.example.customermanagerspringboot.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAllProvince() {
        return (List<Province>) provinceRepository.findAll();
    }

    @Override
    public Province findByIdProvince(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProvince(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
