package com.nttdata.transactionservice.transactionservice.service;

import com.nttdata.transactionservice.transactionservice.dto.DepositDTO;
import com.nttdata.transactionservice.transactionservice.entity.TransactionEntity;

public interface TransactionService {

    public TransactionEntity deposit(DepositDTO depositDTO);

}
