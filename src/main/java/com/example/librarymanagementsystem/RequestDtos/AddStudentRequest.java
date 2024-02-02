package com.example.librarymanagementsystem.RequestDtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddStudentRequest {


    private String name;
    private String branch;

    private double cgpa;
    private String phoneNo;


}
