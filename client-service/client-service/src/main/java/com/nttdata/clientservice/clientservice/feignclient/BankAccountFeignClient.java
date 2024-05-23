package com.nttdata.clientservice.clientservice.feignclient;

import com.nttdata.clientservice.clientservice.model.AccountBankModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "bankaccount-service", url="http://localhost:8002")
public interface BankAccountFeignClient {

    @PostMapping("/bank-account")
    public AccountBankModel save(@RequestBody AccountBankModel accountBankModel);

    @GetMapping("/bank-account/client/{idClient}")
    public List<AccountBankModel> getAccountClients(@PathVariable("idClient") Long idClient);

}
