package com.nttdata.bankaccountservice.bankaccountservice.service;

import com.nttdata.bankaccountservice.bankaccountservice.entity.BankAccountEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface BankAccountService {

    public BankAccountEntity createBankAccount(BankAccountEntity bankAccount);

    BankAccountEntity getBankAccountById(@PathVariable Long id);
}
