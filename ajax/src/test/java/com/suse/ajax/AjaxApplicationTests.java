package com.suse.ajax;

import com.suse.ajax.Bean.City;
import com.suse.ajax.Bean.Province;
import com.suse.ajax.Repository.CityRepository;
import com.suse.ajax.Repository.ProvinceRepository;
import com.suse.ajax.Service.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@SpringBootTest
class AjaxApplicationTests {
@Autowired
	DataSource dataSource;
@Test
	void DataSourceCon() throws SQLException {
	System.out.println("datasource:"+dataSource.getClass());
	Connection connection = dataSource.getConnection();
	System.out.println("connection:"+connection);
}

	//通过省份查找城市
	@Autowired
	CityService cityService;
	@Autowired
	CityRepository cityRepository;
	@Autowired
	ProvinceRepository provinceRepository;
	@Test
	void findCitysByProvince() {
		Province province = provinceRepository.findByProvince("四川");
//		System.out.println(province);
		List<City> cities = cityRepository.findCitiesByProvince(province);
		for (City c : cities) {
			System.out.println(c);
		}
	}

	@Test
	void connectionRedis() {
		Jedis jedis = new Jedis("47.110.57.240", 6379);
		jedis.auth("gg42095");
		System.out.println("Message:"+jedis.ping());
		Set<String> keys = jedis.keys("*");
		for (String key : keys) {
			System.out.println(key);
		}
		System.out.println(jedis.get("name"));
	}
}
