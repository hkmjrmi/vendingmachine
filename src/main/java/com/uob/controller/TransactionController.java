package com.uob.controller;

import com.uob.object.Transaction;
import com.uob.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionServiceImpl;

    @GetMapping("/transactions/list") // Retrieve all Slot
    public List<Transaction> getAllTransactions() {
        return transactionServiceImpl.getAllTransactions();
    }

    @PostMapping("/items/{itemId}/transactions/add")
    public ResponseEntity<Transaction> addItem(@PathVariable(value = "itemId") Long itemId,
                                        @RequestBody Transaction transactionRequest) {
        transactionServiceImpl.newTransaction(itemId, transactionRequest);
        return new ResponseEntity<>(transactionRequest, HttpStatus.CREATED);
    }


}
