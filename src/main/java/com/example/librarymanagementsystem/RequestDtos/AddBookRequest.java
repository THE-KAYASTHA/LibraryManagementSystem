package com.example.librarymanagementsystem.RequestDtos;


import com.example.librarymanagementsystem.Enums.BookGenre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddBookRequest {

    private String bookName;


    private int noOfPages;
    private int price;

    private BookGenre bookGenre;

    private Date publishDate;

    private Integer authorId;



}
