package com.suse.ajax.Service;

import com.suse.ajax.Bean.Province;
import com.suse.ajax.Repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService{
    @Autowired
    ProvinceRepository provinceRepository;
    @Override
    public void saveProvince(Province province) {
        provinceRepository.save(province);
    }
    @Override
    public List<Province> findAll() {
        List<Province> provinceList = provinceRepository.findAll();
        return provinceList;
    }

    @Override
    public Province findByProvince(String province) {
        Province p = provinceRepository.findByProvince(province);
        return p;
    }
}
