package com.nassra.aleen.aleenbookfinalproject.data;

public class MyProfile {
    private String key;
    private String name;
    private String family;
    private String phone;
    private String age;



    public MyProfile() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }




    @Override
    public String toString() {
        return "MyTask{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", family'" + family + '\'' +
                ", phone=" + phone +
                ", age=" + age +
                '}';
    }

}
