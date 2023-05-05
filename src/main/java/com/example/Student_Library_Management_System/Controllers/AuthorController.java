package com.example.Student_Library_Management_System.Controllers;


import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.DTOs.AuthorResponseDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Repository.AuthorRepository;
import com.example.Student_Library_Management_System.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("author")
public class AuthorController {
//    "/ " is optional if want to write then wirte anyway otherwise not needed and not mandatory.


    @Autowired
    AuthorService authorService;
    @PostMapping("add")
    public String addAuthor(@RequestBody AuthorEntryDto authorEntryDto){

            return authorService.createAuthor(authorEntryDto);


    }
    @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor(@RequestParam("authorId") Integer authorId){

        return authorService.getAuthor(authorId);

    }

}
