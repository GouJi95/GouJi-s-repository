package com.suse.ajax.Controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.suse.ajax.Bean.City;
import com.suse.ajax.Bean.Province;
import com.suse.ajax.Service.CityService;
import com.suse.ajax.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.util.List;

@Controller
public class ThymeleafController {
    @Autowired
    ProvinceService provinceService;

    @GetMapping("/thymeleaf")
    public String getThy(Model model) {
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        return "thymeleaf";
    }

    @Autowired
    CityService cityService;
    @PostMapping("/postThy")
    public String postThy(Model model, HttpServletRequest request) {
//        System.out.println("后台接收到数据");
        String province = request.getParameter("province");
//        System.out.println(province);
        Province p = provinceService.findByProvince(province);
        List<City> cities = cityService.getCities(p);
        model.addAttribute("cities", cities);
        return "thymeleaf::city";
    }
}
