package com.uob.service;


import com.uob.object.Item;
import com.uob.object.Slot;
import com.uob.repository.ItemRepository;
import com.uob.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Override
    public List<Item> getAllItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public List<Item> getItemsBySlot(Long slotId) {
       Slot slot = getSlotById(slotId);
       List<Item> item = slot.getItems();
       return item;
    }

    @Override
    public List<Item> getAvailableItems() {
        return itemRepository.findAllByStatus("Available");
    }

    @Override
    public Item saveItem(Item itemRequest) {
        return itemRepository.save(itemRequest);
    }

    @Override
    public Slot getSlotById(Long slotId) {
        Optional<Slot> slotOptional = slotRepository.findById(slotId);
        return slotOptional.orElse(null);
    }


    @Override
    public Item addItemToSlot(Long slotId, Item itemRequest) {
        Slot slot = getSlotById(slotId);
        if (slot.getSize().equals("Small") && itemRequest.getSize().equals("Medium")) {
            throw new RuntimeException("Cannot add medium item to small slot.");
        }
        if (slot.getCurrentQuantity() >= 10) {
            throw new RuntimeException("Slot capacity is already at its maximum limit.");
        }
        itemRequest.setSlot(slot);
        Item addItem = itemRepository.save(itemRequest);
        slot.setCurrentQuantity(slot.getCurrentQuantity() + 1);
        slot.setPrice(addItem.getPrice());
        slotRepository.save(slot);
        return addItem;
    }





}







