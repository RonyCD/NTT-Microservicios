package com.nttdata.bankaccountservice.bankaccountservice.service.impl;

import com.nttdata.bankaccountservice.bankaccountservice.entity.BankAccountEntity;
import com.nttdata.bankaccountservice.bankaccountservice.repository.BankAccountRepository;
import com.nttdata.bankaccountservice.bankaccountservice.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public BankAccountEntity createBankAccount(BankAccountEntity bankAccount) {
        BankAccountEntity newBankAccount = bankAccountRepository.save(bankAccount);
        return newBankAccount;
    }

    @Override
    public BankAccountEntity getBankAccountById(Long id) {
        return bankAccountRepository.findById(id).orElse(null);
    }


}
