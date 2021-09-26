package com.example.learnprograming.viewModels;

public class ExpandableLangDetails_Model {
    private String title;
    private String description;
    private boolean expandable;

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public ExpandableLangDetails_Model(String title, String description) {
        this.title = title;
        this.description = description;
        this.expandable=false;
    }

    public  ExpandableLangDetails_Model(){};

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

    @Override
    public String toString() {
        return "ExpandableLangDetails_Model{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
