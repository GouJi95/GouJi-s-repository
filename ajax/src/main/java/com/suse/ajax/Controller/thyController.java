package com.suse.ajax.Controller;

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
import java.util.List;

@Controller
public class thyController {
    @Autowired
    ProvinceService provinceService;
    @Autowired
    CityService cityService;

    @GetMapping("/thy")
    public String getThy(Model model) {
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        return "thy";
    }

    @PostMapping("/postThy1")
    public String postThy(HttpServletRequest request,Model model) {
        String province = request.getParameter("province");
        Province p = provinceService.findByProvince(province);
        List<City> cities = cityService.getCities(p);
        model.addAttribute("cities", cities);
        return "thy::city";
    }
}
