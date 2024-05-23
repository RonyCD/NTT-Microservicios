package com.nttdata.bankaccountservice.bankaccountservice.service.impl;

import com.nttdata.bankaccountservice.bankaccountservice.entity.BankAccountEntity;
import com.nttdata.bankaccountservice.bankaccountservice.repository.BankAccountRepository;
import com.nttdata.bankaccountservice.bankaccountservice.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccountEntity> listAllAccountBank() {
        return bankAccountRepository.findAll();
    }

    @Override
    public BankAccountEntity getById(Long id) {
        return bankAccountRepository.getById(id);
    }

    @Override
    public BankAccountEntity createAccountBank(BankAccountEntity bankAccount) {
        BankAccountEntity newAccount = bankAccountRepository.save(bankAccount);
        return newAccount;
    }

    @Override
    public List<BankAccountEntity> getAccountsByClientId(Long idClient) {
        return bankAccountRepository.findByIdClient(idClient);
    }
}
