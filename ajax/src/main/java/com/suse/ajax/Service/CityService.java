package com.suse.ajax.Service;

import com.suse.ajax.Bean.City;
import com.suse.ajax.Bean.Province;

import java.util.List;

public interface CityService {
    void saveCity(City city);
    List<City> getCities(Province province);
}
