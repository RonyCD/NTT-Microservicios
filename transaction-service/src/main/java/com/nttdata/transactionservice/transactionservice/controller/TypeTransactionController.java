package com.nttdata.transactionservice.transactionservice.controller;

import com.nttdata.transactionservice.transactionservice.entity.TypeTransactionEntity;
import com.nttdata.transactionservice.transactionservice.service.TypeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type-transaction")
public class TypeTransactionController {

    @Autowired
    private TypeTransactionService typeTransactionService;

    @GetMapping()
    public ResponseEntity<List<TypeTransactionEntity>> listAllTypeAccount() {
        List<TypeTransactionEntity> listTypeTransaction = typeTransactionService.listAllTypeTransaction();
        if(listTypeTransaction.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listTypeTransaction);
    }
}
