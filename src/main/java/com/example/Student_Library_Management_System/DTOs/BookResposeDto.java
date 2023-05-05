package com.example.Student_Library_Management_System.DTOs;

import com.example.Student_Library_Management_System.Enums.Genre;

import java.util.List;

public class BookResposeDto {
    private String name;

    private int pages;
    private Genre genre;


    private List<BookResposeDto> booksWritten;


//    private  double rating;

    public BookResposeDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<BookResposeDto> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(List<BookResposeDto> booksWritten) {
        this.booksWritten = booksWritten;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    private int authorId;

}
