package com.example.librarymanagementsystem.RequestDtos;


import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssociateCardStudentRequest {

    private Integer studentId;
    private Integer cardId;

}
