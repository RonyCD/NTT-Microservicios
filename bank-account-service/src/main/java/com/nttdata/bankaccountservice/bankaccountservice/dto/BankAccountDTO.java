package com.nttdata.bankaccountservice.bankaccountservice.dto;

import lombok.Data;

@Data
public class BankAccountDTO {

    private Long idClient;
    private String typeAccountCode;
    private String numAccount;
    private Double openingAmount;
    private Double balance;
}
