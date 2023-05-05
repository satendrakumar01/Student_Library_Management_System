package com.example.Student_Library_Management_System.Services;


import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.DTOs.AuthorResponseDto;
import com.example.Student_Library_Management_System.DTOs.BookResposeDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public String createAuthor(AuthorEntryDto authorEntryDto){


//        in the params the object is type dto
//        but  repository intracts only with  entities
//        Solutiion: Convert authorEntryDTo __>author



//        Created an object of type Author
//         we are settig its attribute to the set the correct values in DB.  
        Author author=new Author();
        author.setName(authorEntryDto.getName());
        author.setAge((authorEntryDto.getAge()));
        author.setCountry((authorEntryDto.getCountry()));
        author.setRating(authorEntryDto.getRating());
        authorRepository.save(author);




        return "Author added successfully";

    }

    public AuthorResponseDto getAuthor(Integer authorId){

        Author author=authorRepository.findById(authorId).get();

        AuthorResponseDto authorResponseDto=new AuthorResponseDto();

//        sets its attributes;

//        List<Book> ==>list<bookDTo>
        List<Book> bookList=author.getBooksWritten();
        List<BookResposeDto> booksWrittenDto=new ArrayList<>();


        for(Book b:bookList){
            BookResposeDto bookResposeDto=new BookResposeDto();
            bookResposeDto.setName((b.getName()));
            bookResposeDto.setGenre(b.getGenre());
            bookResposeDto.setPages(b.getPage());


            booksWrittenDto.add(bookResposeDto);
        }

//        set the attributes for author reponse dto

        authorResponseDto.setBooksWritten(booksWrittenDto);
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setRating(author.getRating());


        return authorResponseDto;


//

    }
}
