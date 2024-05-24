package com.nttdata.transactionservice.transactionservice.service.impl;

import com.nttdata.transactionservice.transactionservice.dto.BankAccountDTO;
import com.nttdata.transactionservice.transactionservice.dto.DepositDTO;
import com.nttdata.transactionservice.transactionservice.entity.TransactionEntity;
import com.nttdata.transactionservice.transactionservice.entity.TypeTransactionEntity;
import com.nttdata.transactionservice.transactionservice.feignclient.BankAccountFeignClient;
import com.nttdata.transactionservice.transactionservice.repository.TransactionRepository;
import com.nttdata.transactionservice.transactionservice.repository.TypeTransactionRepository;
import com.nttdata.transactionservice.transactionservice.service.TransactionService;

import com.nttdata.transactionservice.transactionservice.service.TypeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BankAccountFeignClient bankAccountFeignClient;

    @Autowired
    private TypeTransactionService typeTransactionService;

    public TransactionEntity deposit(DepositDTO depositDTO) {

        BankAccountDTO bankAccount = bankAccountFeignClient.getBankAccountByIdClient(depositDTO.getIdAccount());
        if (bankAccount == null) {
            throw new RuntimeException("La cuenta bancaria no existe o está inactiva.");
        }

        if (depositDTO.getAmount() <= 0) {
            throw new RuntimeException("El monto del depósito debe ser mayor que cero.");
        }

        bankAccount.setBalance(bankAccount.getBalance() + depositDTO.getAmount());
        bankAccountFeignClient.updateBalance(bankAccount);

        TypeTransactionEntity typeTransaction = typeTransactionService.getTypeTransactionByCode("DE");


        TransactionEntity transaction = TransactionEntity.builder()
                .idBankAccount(depositDTO.getIdAccount())
                .typeTransaction(typeTransaction)
                .senderAccount(depositDTO.getUserCreation())
                .destinationAccount(bankAccount.getNumAccount())
                .amount(depositDTO.getAmount())
                .dateOperation(LocalDateTime.now())
                .userCreation(depositDTO.getUserCreation())
                .build();

        return transactionRepository.save(transaction);
    }

}
