package com.suse.ajax.Controller;

import com.suse.ajax.Bean.City;
import com.suse.ajax.Bean.Province;
import com.suse.ajax.Service.CityService;
import com.suse.ajax.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class cityController {
    @Autowired
    ProvinceService provinceService;
    @GetMapping("/city")
    public String getCity(Model model) {
        List<Province> provinceList = provinceService.findAll();

        model.addAttribute("PList", provinceList);
        return "city";
    }
@Autowired
CityService cityService;
    @RequestMapping("/city")
    public String postCity(@RequestParam String p, @RequestParam String c, RedirectAttributes attributes) {
        Province province = provinceService.findByProvince(p);
        City city = new City(null, c, province);
        cityService.saveCity(city);
        attributes.addFlashAttribute("msg", "创建成功");
        return "redirect:/city";
    }

}
