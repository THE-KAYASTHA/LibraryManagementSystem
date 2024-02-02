package com.example.librarymanagementsystem.Entities;


import com.example.librarymanagementsystem.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class LibraryCard {
    public static final Integer MAX_NO_OF_ALLOWED_BOOKS = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;


    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;
    private int noOfBooksIssued;


    @JoinColumn
    @OneToOne
    private Student student;


    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    public List<Transaction> transactionList=new ArrayList<>();



}
