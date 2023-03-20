package com.uob.controller;

import com.uob.object.Item;
import com.uob.object.Slot;
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

    @PostMapping("/slots/{slotId}/transactions/add")
    public ResponseEntity<Transaction> addItem(@PathVariable(value = "slotId") Long slotId,
                                        @RequestBody Transaction transactionRequest) {
        transactionServiceImpl.newTransaction(slotId, transactionRequest);
        return new ResponseEntity<>(transactionRequest, HttpStatus.CREATED);
    }


}
