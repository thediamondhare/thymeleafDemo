package com.thymeleafDemo.thymeleafDemo.model;

import java.util.List;

public class Student extends Human {

    private String language;
    private List<String> favoriteOS;

    public Student(){}

    public Student(String theFirstName, String theLastName, String theCountry, String theLanguage, List<String> theFavoriteOS) {
        super(theFirstName, theLastName, theCountry);
        language = theLanguage;
        favoriteOS = theFavoriteOS;

    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String theLanguage) {
        language = theLanguage;
    }


    public List<String> getFavoriteOS() {
        return favoriteOS;
    }

    public void setFavoriteOS(List<String> theFavoriteOS) {
        favoriteOS = theFavoriteOS;
    }

}
