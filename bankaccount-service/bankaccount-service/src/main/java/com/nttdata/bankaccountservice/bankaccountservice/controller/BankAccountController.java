package com.nttdata.bankaccountservice.bankaccountservice.controller;

import com.nttdata.bankaccountservice.bankaccountservice.entity.BankAccountEntity;
import com.nttdata.bankaccountservice.bankaccountservice.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/bank-account")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/all")
    public ResponseEntity<List<BankAccountEntity>> listAllAccounts(){
        List<BankAccountEntity> listAccounts = bankAccountService.listAllAccountBank();
        if(listAccounts.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listAccounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccountEntity> getBankAccount(@PathVariable("id") long id){
        BankAccountEntity accountBank = bankAccountService.getById(id);
        if(accountBank == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accountBank);
    }


    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<BankAccountEntity>> getAccountClients(@PathVariable("idClient") Long idClient) {
        List<BankAccountEntity> accounts = bankAccountService.getAccountsByClientId(idClient);
        if (accounts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/new")
    public ResponseEntity<BankAccountEntity> createAccountBank(@RequestBody BankAccountEntity bankAccount) {

        BankAccountEntity newAccountBank = bankAccountService.createAccountBank(bankAccount);
        if (newAccountBank == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok(newAccountBank);
    }

}
