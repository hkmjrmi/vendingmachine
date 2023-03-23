package com.uob.service;

import com.uob.object.Item;
import com.uob.object.Slot;

import java.util.List;

public interface ItemService {

    public List<Item> getAllItems();

    public List<Item> getItemsBySlot(Long slotId);

    public List<Item> getAvailableItems();

    public Item saveItem(Item itemRequest);

    public Item addItemToSlot(Long slotId, Item itemRequest);

    public Slot getSlotById(Long slotId);


}
