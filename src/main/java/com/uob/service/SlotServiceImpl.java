package com.uob.service;

import com.uob.object.Slot;
import com.uob.repository.ItemRepository;
import com.uob.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlotServiceImpl implements SlotService {

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Slot createSlot(Slot slot) {
        int smallSlots = 10;
        int mediumSlots = 10;

        // Retrieve the total number of slots already created from the database
        long totalSlots = slotRepository.count();

        // Check if we've already created 20 slots
        if (totalSlots >= 20) {
            throw new RuntimeException("Slot maximum capacity has been reached");
        }

        // Create 10 small slots
        for (int i = 0; i < smallSlots; i++) {
            // Check if we've already created 20 slots
            if (totalSlots >= 20) {
                break; // Exit the loop
            }

            Slot smallSlot = new Slot();
            smallSlot.setSize("small");
            slotRepository.save(smallSlot);
            totalSlots++;
        }

        // Create 10 medium slots
        for (int i = 0; i < mediumSlots; i++) {
            // Check if we've already created 20 slots
            if (totalSlots >= 20) {
                break; // Exit the loop
            }

            Slot mediumSlot = new Slot();
            mediumSlot.setSize("medium");
            slotRepository.save(mediumSlot);
            totalSlots++;
        }

        // Return the created slot object
        return slot;
    }





    @Override
    public List<Slot> getAllSlots() {
        return (List<Slot>) slotRepository.findAll();
    }

    @Override
    public Slot getSlotById(Long slotId) {
        Optional<Slot> slotOptional = slotRepository.findById(slotId);
        return slotOptional.orElse(null);
    }
}
