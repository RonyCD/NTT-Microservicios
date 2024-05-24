package com.nttdata.transactionservice.transactionservice.service.impl;

import com.nttdata.transactionservice.transactionservice.entity.TypeTransactionEntity;
import com.nttdata.transactionservice.transactionservice.repository.TypeTransactionRepository;
import com.nttdata.transactionservice.transactionservice.service.TypeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeTransactionServiceImpl implements TypeTransactionService {

    @Autowired
    private TypeTransactionRepository typeTransactionRepository;

    @Override
    public List<TypeTransactionEntity> listAllTypeTransaction() {
        return typeTransactionRepository.findAll();
    }


    public TypeTransactionEntity getTypeTransactionByCode(String code) {
        return typeTransactionRepository.findByTransactionCode(code)
                .orElseThrow(() -> new RuntimeException("Tipo de transacción no encontrado: " + code));
    }
}
