package com.suse.ajax.Bean;

import javax.persistence.*;

@Entity
@Table(name = "t_city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", province=" + province +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public City(Long id, String city, Province province) {
        this.id = id;
        this.city = city;
        this.province = province;
    }

    public City() {
    }

    @ManyToOne(targetEntity = Province.class,fetch = FetchType.EAGER)
    private Province province;
}
