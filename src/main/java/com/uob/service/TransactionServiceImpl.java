package com.uob.service;

import com.uob.object.Slot;
import com.uob.object.Transaction;
import com.uob.repository.SlotRepository;
import com.uob.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Override
    public List<Transaction> getAllTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Long transactionId) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(transactionId);
        return transactionOptional.orElse(null);
    }

    @Override
    public Slot getSlotById(Long slotId) {
        Optional<Slot> slotOptional = slotRepository.findById(slotId);
        return slotOptional.orElse(null);
    }



    @Override
    public Transaction newTransaction(Long slotId, Transaction transactionRequest) {
        Slot slot = getSlotById(slotId);
        if(slot.getCapacity() <= 0) {
            throw new IllegalStateException("Invalid Transaction! Empty Slot.");
        }
        transactionRequest.setSlot(slot);
        transactionRequest.setAmount(slot.getPrice()); // set transaction amount to slot price
        Transaction addTransaction = transactionRepository.save(transactionRequest);
        slot.setCapacity(slot.getCapacity() - 1);
        slotRepository.save(slot);
        return addTransaction;
    }








}
