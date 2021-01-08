package com.suse.ajax.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.suse.ajax.Bean.City;
import com.suse.ajax.Bean.Province;
import com.suse.ajax.Service.CityService;
import com.suse.ajax.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ajaxController {
    @Autowired
    ProvinceService provinceService;

    @GetMapping("/ajax")
    public String getCity(Model model) {
        List<Province> provinceList = provinceService.findAll();
        model.addAttribute("PList", provinceList);
        return "ajax";
    }
    @GetMapping("/ajax1")
    public String getCity1(Model model) {
        List<Province> provinceList = provinceService.findAll();
        model.addAttribute("PList", provinceList);
        return "ajax1";
    }

    @Autowired
    CityService cityService;

    @GetMapping("/getCities")
    void getCities(Model model, HttpServletResponse rs, HttpServletRequest re) throws IOException {
        String province = re.getParameter("province");
        Province p = provinceService.findByProvince(province);
        List<City> cities = cityService.getCities(p);
        rs.setContentType("application/json;charset=utf-8");
        PrintWriter writer = rs.getWriter();
        ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString(cities);
        writer.println(s);
        writer.flush();
        writer.close();
    }
    @GetMapping("/getCities1")
    String  getCities1(Model model, HttpServletResponse rs, HttpServletRequest re) throws IOException {
        String province = re.getParameter("province");
        Province p = provinceService.findByProvince(province);
        List<City> cities = cityService.getCities(p);
        model.addAttribute("cities", cities);
        return "ajax1::city";
    }

}
