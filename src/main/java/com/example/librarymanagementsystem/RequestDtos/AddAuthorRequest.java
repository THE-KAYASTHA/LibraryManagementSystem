package com.example.librarymanagementsystem.RequestDtos;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAuthorRequest
{
    private String authorName;



    private String emailId;


    private int authorAge;


}
