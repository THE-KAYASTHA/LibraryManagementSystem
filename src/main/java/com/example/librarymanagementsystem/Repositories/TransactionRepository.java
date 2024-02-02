package com.example.librarymanagementsystem.Repositories;

import com.example.librarymanagementsystem.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,String> {

}
