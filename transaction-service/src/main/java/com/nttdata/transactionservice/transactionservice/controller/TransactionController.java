package com.nttdata.transactionservice.transactionservice.controller;

import com.nttdata.transactionservice.transactionservice.dto.DepositDTO;
import com.nttdata.transactionservice.transactionservice.entity.TransactionEntity;
import com.nttdata.transactionservice.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity<TransactionEntity> deposit(@RequestBody DepositDTO depositDTO) {
        TransactionEntity newTransaction = transactionService.deposit(depositDTO);
        return ResponseEntity.ok(newTransaction);
    }

}
