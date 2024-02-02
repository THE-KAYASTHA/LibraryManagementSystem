package com.example.librarymanagementsystem.Controllers;


import com.example.librarymanagementsystem.RequestDtos.AddAuthorRequest;
import com.example.librarymanagementsystem.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {


    @Autowired
    private  AuthorService authorService;

    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody AddAuthorRequest addAuthorRequest){

        String result=authorService.addAuthor(addAuthorRequest);
        return result;



    }


}
