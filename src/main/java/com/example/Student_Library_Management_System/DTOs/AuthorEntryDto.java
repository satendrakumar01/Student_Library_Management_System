package com.example.Student_Library_Management_System.DTOs;



//this just an object

public class AuthorEntryDto {

//    This is just an object that will be used to take request from the postman.


//    It will contain the parameters that  we want to sent from the postman

//    id is not here because we don't want to sent it from post man.

    private String name;
    private int age;
    private String country;
    private double rating;



    public AuthorEntryDto(){

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
