package com.uob.service;

import com.uob.object.Item;
import com.uob.object.Slot;
import com.uob.object.Transaction;

import java.util.List;

public interface TransactionService {

    public List<Transaction> getAllTransactions();

    public Transaction getTransactionById(Long transactionId);


    public Slot getSlotById(Long slotId);

    public Item getItemById(Long itemId);

    Transaction newTransaction(Long slotId, Transaction transactionRequest);
}
