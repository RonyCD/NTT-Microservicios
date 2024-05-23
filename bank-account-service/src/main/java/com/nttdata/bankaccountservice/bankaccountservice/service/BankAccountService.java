package com.nttdata.bankaccountservice.bankaccountservice.service;

import com.nttdata.bankaccountservice.bankaccountservice.entity.BankAccountEntity;

public interface BankAccountService {

    public BankAccountEntity createBankAccount(BankAccountEntity bankAccount);

    public BankAccountEntity getBankAccount(Long id);
}
