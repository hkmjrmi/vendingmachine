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
        return slotRepository.save(slot);
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
