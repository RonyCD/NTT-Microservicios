package com.nttdata.transactionservice.transactionservice.service;

import com.nttdata.transactionservice.transactionservice.entity.TypeTransactionEntity;

import java.util.List;

public interface TypeTransactionService {

    public List<TypeTransactionEntity> listAllTypeTransaction();

    TypeTransactionEntity getTypeTransactionByCode(String code);

}
