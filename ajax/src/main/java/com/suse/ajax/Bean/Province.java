package com.suse.ajax.Bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String province;

    public Province(Long id, String province) {
        this.id = id;
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Province() {
    }


    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", province='" + province + '\'' +
                '}';
    }

    @OneToMany(fetch = FetchType.EAGER)
    private List<City> cities = new ArrayList<>();
}
