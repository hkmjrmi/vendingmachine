package com.uob.controller;

import com.uob.service.SlotServiceImpl;
import com.uob.object.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SlotController {

    @Autowired
    private SlotServiceImpl slotServiceImpl;

    @GetMapping("/slots/list") // Retrieve all Slot
    public List<Slot> getAllSlots() {
        return slotServiceImpl.getAllSlots();
    }

    @GetMapping("/slots/{slotId}") // Retrieve selected Slot
    public ResponseEntity<Slot> getSlot(@PathVariable Long slotId) {
        Slot slot = slotServiceImpl.getSlotById(slotId);
        return ResponseEntity.ok(slot);
    }

    @PostMapping("/slots/create")
    public ResponseEntity<String> createSlot(@RequestBody Slot slot) {
        Slot createdSlot = slotServiceImpl.createSlot(slot);
        return ResponseEntity.ok("Slot created");
    }



}
