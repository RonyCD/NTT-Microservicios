package com.nttdata.transactionservice.transactionservice.feignclient;

import com.nttdata.transactionservice.transactionservice.dto.BankAccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bank-account-service", url = "http://localhost:8002")
public interface BankAccountFeignClient {

    @GetMapping("/bank-account/{id}")
    BankAccountDTO getBankAccountByIdClient(@PathVariable("id") Long idClient);

    @PutMapping("/bank-account/updateBalance")
    void updateBalance(@RequestBody BankAccountDTO bankAccountDTO);
}
