package com.nttdata.bankaccountservice.bankaccountservice.repository;

import com.nttdata.bankaccountservice.bankaccountservice.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity, Long> {

    List<BankAccountEntity> findByIdClient(Long idClient);
}
