package com.nttdata.clientservice.clientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDTO {

    private Long idClient;
    private String typeAccountCode;
    private String numAccount;
    private Double openingAmount;
    private Double balance;
}
