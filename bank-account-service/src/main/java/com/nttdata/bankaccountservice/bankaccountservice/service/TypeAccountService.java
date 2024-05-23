package com.nttdata.bankaccountservice.bankaccountservice.service;

import com.nttdata.bankaccountservice.bankaccountservice.entity.TypeAccountEntity;

import java.util.List;

public interface TypeAccountService {

    public List<TypeAccountEntity> listAllTypeAccount();

    TypeAccountEntity getTypeAccountByAccountCode(String accountCode);
}
