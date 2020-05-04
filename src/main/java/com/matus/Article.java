package com.matus;

import java.util.List;

public class Article {
    private String name;
    private String mail;
    private String age;
    private String gender;
    private String birthDay;
    private String sity;
    private String phone;
    private String url;
    private String compesation;

    public String getListInOneString() {
        return listInOneString;
    }

    private String listInOneString;

    public void setListInOneString(String listInOneString) {
        this.listInOneString = listInOneString;
    }

    private List<String> list;
    private List<String> exp;
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public List<String> getExp() {
        return exp;
    }
    public void setExp(List<String> exp) {
        this.exp = exp;
    }
    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    public String getSity() {
        return sity;
    }
    public void setSity(String sity) {
        this.sity = sity;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getCompesation() {
        return compesation;
    }
    public void setCompesation(String compesation) {
        this.compesation = compesation;
    }
}
