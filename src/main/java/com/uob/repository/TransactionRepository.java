package com.uob.repository;

import com.uob.object.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository <Transaction, Long> {
}
