package com.suse.ajax.Service;

import com.suse.ajax.Bean.City;
import com.suse.ajax.Bean.Province;
import com.suse.ajax.Repository.CityRepository;
import com.suse.ajax.Repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;
    @Autowired
    ProvinceRepository provinceRepository;
@Transactional
    @Override
    public void saveCity(City city) {
        cityRepository.save(city);
    }

    @Override
    public List<City> getCities(Province province) {
        List<City> cities = cityRepository.findCitiesByProvince(province);
        return cities;
    }
}
