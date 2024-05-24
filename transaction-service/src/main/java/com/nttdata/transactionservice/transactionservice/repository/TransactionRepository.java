package com.nttdata.transactionservice.transactionservice.repository;

import com.nttdata.transactionservice.transactionservice.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {


}