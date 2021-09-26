package com.example.learnprograming.viewModels;

public class MainLanguagesModel {


    private String name;
    private String imgURL;

    public MainLanguagesModel(String imgURL, String name){
        this.imgURL = imgURL;
        this.name = name;

    }
    public MainLanguagesModel(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
