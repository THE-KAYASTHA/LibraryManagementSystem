package com.example.librarymanagementsystem.Entities;

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
@Table(name="Author")

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;


    private String authorName;


    @Column(unique = true,nullable = false)
    private String emailId;


    private int authorAge;

    private int noOfBooksWritten;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> bookList=new ArrayList<>();
    public Author(String authorName, int authorAge, String emailId) {
        this.authorAge=authorAge;
        this.authorName=authorName;
        this.emailId=emailId;
    }

}
