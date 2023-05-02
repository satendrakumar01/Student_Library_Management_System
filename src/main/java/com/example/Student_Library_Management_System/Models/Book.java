package com.example.Student_Library_Management_System.Models;


import com.example.Student_Library_Management_System.Enums.Genre;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int page;


    @Enumerated(value = EnumType.STRING)
    private Genre genre;


//    Book is the child wrt to author
//    Setting here the forign key :Standard 3 steps

//    @Column(name = )
    @ManyToOne
    @JoinColumn //Add an extra attribute of  author Id ( Parent table primiary key for the foreign key of the child table
    private Author author; // this is parent entity we are connecting with

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public List<Transactions> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(List<Transactions> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }

    @ManyToOne
    @JoinColumn
    private Card card;

    private  boolean issued;


    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transactions> listOfTransactions=new ArrayList<>();
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public Book(){

    }
    public Book(int id, String name, int page, Genre genre) {
        this.id = id;
        this.name = name;
        this.page = page;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


}
