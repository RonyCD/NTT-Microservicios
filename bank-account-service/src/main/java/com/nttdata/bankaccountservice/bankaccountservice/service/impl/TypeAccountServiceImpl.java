package com.nttdata.bankaccountservice.bankaccountservice.service.impl;

import com.nttdata.bankaccountservice.bankaccountservice.entity.TypeAccountEntity;
import com.nttdata.bankaccountservice.bankaccountservice.repository.TypeAccountRepository;
import com.nttdata.bankaccountservice.bankaccountservice.service.TypeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeAccountServiceImpl implements TypeAccountService {

    @Autowired
    private TypeAccountRepository typeAccountRepository;

    @Override
    public List<TypeAccountEntity> listAllTypeAccount() {
        return typeAccountRepository.findAll();
    }

    @Override
    public TypeAccountEntity getTypeAccountByAccountCode(String accountCode) {
        return typeAccountRepository.findByAccountCode(accountCode);
    }
}
