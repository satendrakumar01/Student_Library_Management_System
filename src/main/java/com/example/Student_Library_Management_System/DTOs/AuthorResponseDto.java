package com.example.Student_Library_Management_System.DTOs;

import java.util.List;

public class AuthorResponseDto {

    private String name;
    private int age;
    private String country;

    private double rating;

    private List<BookResposeDto> booksWritten;

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

    public List<BookResposeDto> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(List<BookResposeDto> booksWritten) {
        this.booksWritten = booksWritten;
    }
}
