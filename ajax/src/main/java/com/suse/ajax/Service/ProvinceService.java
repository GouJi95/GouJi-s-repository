package com.suse.ajax.Service;

import com.suse.ajax.Bean.Province;

import java.util.List;

public interface ProvinceService {
    public void saveProvince(Province province);
    public List<Province> findAll();
    public Province findByProvince(String province);
}
