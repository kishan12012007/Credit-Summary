package com.example.creditsummary;

public class model {

    private String Cash;
    private String date;
    private String name;
    private String Type;
    private int id ;

    public String getCash() {
        return Cash;
    }

    public void setCash(String cash) {
        Cash = cash;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public model(String name, String date, String cash, String type) {
        Cash = cash;
        this.date = date;
        this.name = name;
        Type = type;
    }

}
