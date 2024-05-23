package com.nttdata.bankaccountservice.bankaccountservice.controller;

import com.nttdata.bankaccountservice.bankaccountservice.dto.BankAccountDTO;
import com.nttdata.bankaccountservice.bankaccountservice.entity.BankAccountEntity;
import com.nttdata.bankaccountservice.bankaccountservice.entity.TypeAccountEntity;
import com.nttdata.bankaccountservice.bankaccountservice.service.BankAccountService;
import com.nttdata.bankaccountservice.bankaccountservice.service.TypeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank-account")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;
    @Autowired
    private TypeAccountService typeAccountService;


    @PostMapping("/new")
    public ResponseEntity<BankAccountEntity> createBankAccount(@RequestBody BankAccountDTO bankAccountDTO) {
        TypeAccountEntity typeAccount = typeAccountService.getTypeAccountByAccountCode(bankAccountDTO.getTypeAccountCode());
        if (typeAccount == null) {
            return ResponseEntity.badRequest().build();
        }

        BankAccountEntity bankAccount = BankAccountEntity.builder()
                .idClient(bankAccountDTO.getIdClient())
                .typeAccount(typeAccount)
                .numAccount(bankAccountDTO.getNumAccount())
                .openingAmount(bankAccountDTO.getOpeningAmount())
                .balance(bankAccountDTO.getBalance())
                .build();

        BankAccountEntity newBankAccount = bankAccountService.createBankAccount(bankAccount);

        if (newBankAccount == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newBankAccount);
    }

}
