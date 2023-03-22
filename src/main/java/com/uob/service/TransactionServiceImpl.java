package com.uob.service;

import com.uob.object.Item;
import com.uob.object.Slot;
import com.uob.object.Transaction;
import com.uob.repository.ItemRepository;
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
    private ItemRepository itemRepository;

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
    public Item getItemById(Long itemId) {
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        return itemOptional.orElse(null);
    }



    @Override
    public Transaction newTransaction(Long itemId, Transaction transactionRequest) {
        Item item = getItemById(itemId);
        Slot slot = item.getSlot();

        if(slot.getCurrentQuantity() <= 0) {
            throw new IllegalStateException("Invalid Transaction! Empty Slot.");
        }
        transactionRequest.setItem(item);
        transactionRequest.setAmount(slot.getPrice()); // set transaction amount to slot price
        Transaction addTransaction = transactionRepository.save(transactionRequest);
        item.setStatus("Purchased");
        slot.setCurrentQuantity(slot.getCurrentQuantity() - 1);
        itemRepository.save(item);
        slotRepository.save(slot);
        return addTransaction;
    }








}
