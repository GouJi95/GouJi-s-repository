package com.suse.ajax.Controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.suse.ajax.Bean.Province;
import com.suse.ajax.Service.ProvinceService;
import com.suse.ajax.Service.ProvinceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class provinceController {
    @Autowired
    ProvinceService provinceService;
    @GetMapping("/province")
    public String getProvince(Province province, RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("msg", null);
        return "province";
    }
    @PostMapping("/province")
    public String postProvince(@RequestParam(name = "province") String p, RedirectAttributes redirectAttributes) {
        System.out.println(p);
        Province province = new Province(null,p);
        provinceService.saveProvince(province);
        redirectAttributes.addFlashAttribute("msg", "创建成功");
        return "redirect:/province";
    }
}
