package com.synex.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AddressD {
    
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id private int id;
    private int houseNo;
    private String city;
    private String province;
    private String country;
    private long phone;
    
    public AddressD() {};
    
    public AddressD(int id, int houseNo, String city, String province, String country, long phone) {
        super();
        this.id = id;
        this.houseNo = houseNo;
        this.city = city;
        this.province = province;
        this.country = country;
        this.phone = phone;
    }

    public AddressD(int houseNo, String city, String province, String country, long phone) {
        this.houseNo = houseNo;
        this.city = city;
        this.province = province;
        this.country = country;
        this.phone = phone;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
    
}
