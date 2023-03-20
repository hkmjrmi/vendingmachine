package com.uob.service;

import com.uob.object.Slot;

import java.util.List;

public interface SlotService {

    public List<Slot> getAllSlots();

    public Slot getSlotById(Long slotId);

    public Slot createSlot(Slot slot);

}
