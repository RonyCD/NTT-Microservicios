package com.nttdata.transactionservice.transactionservice.repository;

import com.nttdata.transactionservice.transactionservice.entity.TypeTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeTransactionRepository extends JpaRepository<TypeTransactionEntity, Long> {

    Optional<TypeTransactionEntity> findByTransactionCode(String transactionCode);


}
