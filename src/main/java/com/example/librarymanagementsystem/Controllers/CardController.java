package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.Entities.LibraryCard;
import com.example.librarymanagementsystem.RequestDtos.AssociateCardStudentRequest;
import com.example.librarymanagementsystem.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/addCard")
    public String addCard(){

        return cardService.addCard();

    }

    @GetMapping("/getCard")
    public LibraryCard getCard(@RequestParam Integer cardId ){

        return cardService.getCard(cardId);
    }

    @PutMapping("/associateCardAndStudent")
    public ResponseEntity associateCardAndStudent(@RequestBody AssociateCardStudentRequest associateCardStudentRequest){
        try{
            String result =cardService.associateCardAndStudent(associateCardStudentRequest);
            return new ResponseEntity(result, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }


    }

}
