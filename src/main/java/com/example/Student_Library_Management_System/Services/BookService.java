package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;


    public String addBook(BookRequestDto bookRequestDto ){

//        first need to get authro id ;

        int authorId=bookRequestDto.getAuthorId();

//        Now i will be fetching the author entity

        Author author=authorRepository.findById(authorId).get();

//        converter
//        we have created this entity so that we can save it into the Db
        Book book =new Book();


        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);
        book.setName(bookRequestDto.getName());
        book.setPage(bookRequestDto.getPages());




//        Basic attributes are already set from postman

//        Settig the forigen attribute in the child class;

        book.setAuthor(author);

//        we need to update the list of books written in parent class;

        List<Book> currentBooksWritten=author.getBooksWritten();
        currentBooksWritten.add(book);
//        author.setBooksWritten(currentBooksWritten);



//        Now the book is to be save but also author is to be save;
//        Why do wee need to save (updateing) the authro: bcz  the author enitity has been updated or resave;


          authorRepository.save(author);

//          .save function both save func also and as update func also;

//        bookRepo.save is not required bcz it will be auto called by the cascading
//        effect :because it save the book twice;

        return "Book Added successfully";







    }
}
