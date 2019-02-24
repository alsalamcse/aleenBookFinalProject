package com.nassra.aleen.aleenbookfinalproject.data;

public class MyBook {
    private String key;
    private String name;
    private String writer;
    private String year;
    private String them;
    private String recomm;



    public MyBook() {

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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getThem() {
        return them;
    }

    public void setThem(String them) {
        this.them = them;
    }
    public String getRecomm() {
        return recomm;
    }

    public void setRecomm(String recomm) {
        this.them = them;
    }






    @Override
    public String toString() {
        return "MyTask{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", writer:'" + writer + '\'' +
                ", year:" + year +
                ", them:" + them +
                ", recommandition:" + recomm +
                '}';
    }
}
