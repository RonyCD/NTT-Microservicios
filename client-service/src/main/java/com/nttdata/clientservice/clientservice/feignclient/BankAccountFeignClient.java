package com.nttdata.clientservice.clientservice.feignclient;

import com.nttdata.clientservice.clientservice.dto.BankAccountDTO;
import com.nttdata.clientservice.clientservice.entity.bankaccount.BankAccountEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bank-account-service")
public interface BankAccountFeignClient {

    @PostMapping("/bank-account/new")
    ResponseEntity<BankAccountEntity> createBankAccount(@RequestBody BankAccountDTO bankAccountDTO);
}
