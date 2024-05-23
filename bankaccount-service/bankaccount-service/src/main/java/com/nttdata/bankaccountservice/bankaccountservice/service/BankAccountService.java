package com.nttdata.bankaccountservice.bankaccountservice.service;

import com.nttdata.bankaccountservice.bankaccountservice.entity.BankAccountEntity;

import java.util.List;

public interface BankAccountService {

    public List<BankAccountEntity> listAllAccountBank();

    public BankAccountEntity getById(Long id);

    public BankAccountEntity createAccountBank(BankAccountEntity bankAccount);

    List<BankAccountEntity> getAccountsByClientId(Long idClient);
}
