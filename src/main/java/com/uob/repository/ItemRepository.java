package com.uob.repository;

import com.uob.object.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository <Item, Long> {
    List<Item> findAllByStatus(String status);

    List<Item> findAllBySlot(Long slotId);
}
