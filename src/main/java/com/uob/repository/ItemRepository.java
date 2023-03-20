package com.uob.repository;

import com.uob.object.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository <Item, Long> {
}
