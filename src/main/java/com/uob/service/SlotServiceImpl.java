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
        int slotsCreated = 0;
        while (slotsCreated < 20) {
            // Create 10 small slots
            for (int i = 0; i < smallSlots; i++) {
                Slot smallSlot = new Slot();
                smallSlot.setSize("small");
                slotRepository.save(smallSlot);
                slotsCreated++;
            }

            // Create 10 medium slots
            for (int i = 0; i < mediumSlots; i++) {
                Slot mediumSlot = new Slot();
                mediumSlot.setSize("medium");
                slotRepository.save(mediumSlot);
                slotsCreated++;
            }
        }
        return slot; // Return the created slot object
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
