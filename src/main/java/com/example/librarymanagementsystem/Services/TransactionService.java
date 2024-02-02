package com.example.librarymanagementsystem.Services;


import com.example.librarymanagementsystem.Entities.Book;
import com.example.librarymanagementsystem.Entities.LibraryCard;
import com.example.librarymanagementsystem.Entities.Transaction;
import com.example.librarymanagementsystem.Enums.TransactionStatus;
import com.example.librarymanagementsystem.Enums.TransactionType;
import com.example.librarymanagementsystem.Exceptions.BookNotAvailableException;
import com.example.librarymanagementsystem.Exceptions.BookNotFoundException;
import com.example.librarymanagementsystem.Exceptions.CardNotFoundException;
import com.example.librarymanagementsystem.Exceptions.MaxLimitReachedException;
import com.example.librarymanagementsystem.Repositories.BookRepository;
import com.example.librarymanagementsystem.Repositories.CardRepository;
import com.example.librarymanagementsystem.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;
    public String issueBook(Integer cardId, Integer bookId) throws Exception {


        Transaction transaction=new Transaction();
        transaction.setTransactionType(TransactionType.ISSUED);
        transaction.setTransactionStatus(TransactionStatus.ONGOING);


        //get book

        Optional<Book> bookOptional=bookRepository.findById(bookId);

        if(bookOptional.isEmpty()){
            throw new BookNotFoundException("BookId entered is invalid");
        }


        Book book=bookOptional.get();

        Optional<LibraryCard> optionalLibraryCard=cardRepository.findById(cardId);

        if(optionalLibraryCard.isEmpty()){
            throw new CardNotFoundException("Card Id entered is invalid");
        }
        LibraryCard card=optionalLibraryCard.get();


        if(book.getIsAvailable()==Boolean.FALSE){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction=transactionRepository.save(transaction);
            throw new BookNotAvailableException("Book with the bookId is not available. TransactionId "+transaction.getTransactionId());
        }
        if(card.getNoOfBooksIssued()>=LibraryCard.MAX_NO_OF_ALLOWED_BOOKS){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction=transactionRepository.save(transaction);
            throw new MaxLimitReachedException("You have reached the max limit of issed books" +
                    "please return a book in order to issue new " +
                    "Transaction Id"+transaction.getTransactionId());

        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        book.setIsAvailable(false);
        card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);

        transaction=transactionRepository.save(transaction);

        return "The transaction with Id"+transaction.getTransactionId()+" has been saved to the DB";







    }
}
