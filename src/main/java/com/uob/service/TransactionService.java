package com.uob.service;

import com.uob.object.Slot;
import com.uob.object.Transaction;

import java.util.List;

public interface TransactionService {

    public List<Transaction> getAllTransactions();

    public Transaction getTransactionById(Long transactionId);


    public Slot getSlotById(Long slotId);

    Transaction newTransaction(Long slotId, Transaction transactionRequest);
}
