package com.uob.controller;

import com.uob.service.ItemServiceImpl;
import com.uob.service.SlotServiceImpl;
import com.uob.object.Item;
import com.uob.repository.ItemRepository;
import com.uob.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemServiceImpl itemServiceImpl;

    private ItemRepository itemRepository;

    private SlotRepository slotRepository;

    @Autowired
    private SlotServiceImpl slotServiceImpl;

    @GetMapping("/items/list") // Retrieve all items
    public List<Item> getAllItems() {
        return itemServiceImpl.getAllItems();
    }

    @GetMapping("/items/available/list") // Retrieve all items
    public List<Item> getAvailableItems() {
        return itemServiceImpl.getAvailableItems();
    }

    @PostMapping("/slots/{slotId}/items/add")
    public ResponseEntity<Item> addItem(@PathVariable(value = "slotId") Long slotId,
                                           @RequestBody Item itemRequest) {
        itemServiceImpl.addItemToSlot(slotId, itemRequest);
        return new ResponseEntity<>(itemRequest, HttpStatus.CREATED);
    }

    @GetMapping("/slots/{slotId}/items")
    public List<Item> getItemsBySlot(@PathVariable(value = "slotId") Long slotId) {
        return itemServiceImpl.getItemsBySlot(slotId);
    }



}
