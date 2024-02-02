package com.example.librarymanagementsystem.Services;


import com.example.librarymanagementsystem.Entities.LibraryCard;
import com.example.librarymanagementsystem.Entities.Student;
import com.example.librarymanagementsystem.Enums.CardStatus;
import com.example.librarymanagementsystem.Repositories.CardRepository;
import com.example.librarymanagementsystem.Repositories.StudentRepository;
import com.example.librarymanagementsystem.RequestDtos.AssociateCardStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private StudentRepository studentRepository;
    public String addCard() {
        LibraryCard newCard = new LibraryCard();
        newCard.setCardStatus(CardStatus.NEW);
        newCard.setNoOfBooksIssued(0);
        LibraryCard saveCard=cardRepository.save(newCard);
    return "New Card with Card No "+saveCard.getCardId()+" has been generated";
    }

    public String associateCardAndStudent(AssociateCardStudentRequest associateCardStudentRequest)throws Exception {

        Integer cardId=associateCardStudentRequest.getCardId();
        Integer studentId=associateCardStudentRequest.getStudentId();

        Optional<Student> studentOptional=studentRepository.findById(studentId);
        if(studentOptional.isEmpty()){
            throw new Exception("Invalid StudentID is entered");
        }
        Student student=studentOptional.get();
        Optional<LibraryCard> libraryCardOptional=cardRepository.findById(cardId);

        if(libraryCardOptional.isEmpty()){
            throw new Exception("Invalid CardID is entered");
        }

        LibraryCard libraryCard=libraryCardOptional.get();

        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);
        libraryCard.setNoOfBooksIssued(0);
        cardRepository.save(libraryCard);
        return  "Card with cardId "+cardId+" and student with studentId "+studentId+" are associated";
        // we save only in child

    }


    public LibraryCard getCard(Integer cardId) {

        return cardRepository.findById(cardId).get();



    }
}
