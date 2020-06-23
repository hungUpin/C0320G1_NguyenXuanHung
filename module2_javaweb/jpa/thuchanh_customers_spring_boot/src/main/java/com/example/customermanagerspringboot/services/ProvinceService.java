package com.example.customermanagerspringboot.services;

import com.example.customermanagerspringboot.models.Province;

import java.util.List;
import java.util.Properties;

public interface ProvinceService {
    List<Province> findAllProvince();
    Province findByIdProvince(Long id);
    void saveProvince(Province province);
    void remove(Long id);
}
