package com.example.librarymanagementsystem.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentID;
    private String name;
    private String branch;
    private String phoneNo;
    private double cgpa;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private LibraryCard libraryCard;

    public Student(String name, String branch, double cgpa, String phoneNo) {
    this.name=name;
    this.branch=branch;
    this.cgpa=cgpa;
    this.phoneNo=phoneNo;

    }
}
