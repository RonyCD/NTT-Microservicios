package com.nttdata.bankaccountservice.bankaccountservice.repository;

import com.nttdata.bankaccountservice.bankaccountservice.entity.TypeAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeAccountRepository extends JpaRepository<TypeAccountEntity, Long> {

    TypeAccountEntity findByAccountCode(String accountCode);

}
