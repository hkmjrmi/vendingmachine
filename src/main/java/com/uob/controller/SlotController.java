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

    @PostMapping("/slots/create") // Initialize New Slot
    public ResponseEntity<Slot> createSlot(@RequestBody Slot slotRequest) {
        Slot slot = slotServiceImpl.createSlot(slotRequest);
        return ResponseEntity.ok(slot);
    }

}
