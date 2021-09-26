package com.example.learnprograming.viewModels;

public class LangDetails {

    public LangDetails(String title, String description, String imgDetails) {
        this.title = title;
        this.description = description;
        this.imgDetails = imgDetails;
    }
    public LangDetails(){}

    String title;
    String description;
    String imgDetails;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgDetails() {
        return imgDetails;
    }

    public void setImgDetails(String imgDetails) {
        this.imgDetails = imgDetails;
    }
}
