package com.nttdata.bankaccountservice.bankaccountservice.controller;

import com.nttdata.bankaccountservice.bankaccountservice.entity.TypeAccountEntity;
import com.nttdata.bankaccountservice.bankaccountservice.service.TypeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
@RequestMapping("/type-account")
public class TypeAccountController {

    @Autowired
    private TypeAccountService typeAccountService;

    @GetMapping()
    public ResponseEntity<List<TypeAccountEntity>> listAllTypeAccount() {
        List<TypeAccountEntity> listTypeAccount = typeAccountService.listAllTypeAccount();
        if(listTypeAccount.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listTypeAccount);
    }
}
