package com.synex.model;

public class Address {
    
    int houseNo;
    String city;
    String province;
    String country;
    int phone;
    
    public Address() {};
    
    public Address(int houseNo, String city, String province, String country, int phone) {
        this.houseNo = houseNo;
        this.city = city;
        this.province = province;
        this.country = country;
        this.phone = phone;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
}
