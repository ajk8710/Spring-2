package com.synex.model;

public class Address {
    
    int houseNo;
    String city;
    String province;
    String country;
    long phone;
    
    public Address() {};
    
    public Address(int houseNo, String city, String province, String country, long phone) {
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
    
}
