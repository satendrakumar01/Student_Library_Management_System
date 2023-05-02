package com.example.Student_Library_Management_System.Services;


import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
