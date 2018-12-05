package com.example.anumabbas.traveljournal;

/**
 * Created by anumabbas on 28/10/2018.
 */

public class ProfileInfo {

private String Uid;
private String key;
    private String Name;
    private String Age;
    private String City;
    private String Country;
    private String Phone;
    public ProfileInfo()
    {

    }

    public ProfileInfo(String name, String age, String city, String country, String phone,String ui,String k) {
        Name = name;
        Age = age;
        City = city;
        Country = country;
        Phone = phone;
        key=k;
        Uid=ui;
    }
    public String getUid()
    {
        return Uid;
    }
    public String getKey()
    {
        return key;
    }
    public void setUid(String uid) {
        Age = uid;
    }

    public void setKey(String key) {
        this.key=key;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }


}
