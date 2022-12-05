package com.example.creditsummary;

public class model2 {

    private String name_1;
    private String date_1;
    private String cash_1;
    private String category_1;
    private String cash_back;

    public model2(String name_1, String date_1, String cash_1, String category_1, String cash_back) {
        this.name_1 = name_1;
        this.date_1 = date_1;
        this.cash_1 = cash_1;
        this.category_1 = category_1;
        this.cash_back = cash_back;
    }

    public String getName_1() {
        return name_1;
    }

    public void setName_1(String name_1) {
        this.name_1 = name_1;
    }

    public String getDate_1() {
        return date_1;
    }

    public void setDate_1(String date_1) {
        this.date_1 = date_1;
    }

    public String getCash_1() {
        return cash_1;
    }

    public void setCash_1(String cash_1) {
        this.cash_1 = cash_1;
    }

    public String getCategory_1() {
        return category_1;
    }

    public void setCategory_1(String category_1) {
        this.category_1 = category_1;
    }

    public String getCash_back() {
        return cash_back;
    }

    public void setCash_back(String cash_back) {
        this.cash_back = cash_back;
    }
}
