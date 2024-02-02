package com.example.librarymanagementsystem.Entities;


import com.example.librarymanagementsystem.Enums.BookGenre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(unique = true)
    private String bookName;


    private int noOfPages;
    private int price;
    @Enumerated(value = EnumType.STRING)
    private BookGenre bookGenre;

    private Boolean isAvailable;
    private Date publishDate;

     @JoinColumn
    @ManyToOne
    private Author author;

    public Book(String bookName, BookGenre bookGenre, int noOfPages, int price, Date publishDate) {
    this.bookName=bookName;
    this.bookGenre=bookGenre;
    this.noOfPages=noOfPages;
    this.price=price;
    this.publishDate=publishDate;

    }


    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transaction> transactionList=new ArrayList<>();
}
