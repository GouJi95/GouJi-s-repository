package com.suse.ajax.Repository;

import com.suse.ajax.Bean.City;
import com.suse.ajax.Bean.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {
    List<City> findCitiesByProvince(Province province);
}
