package com.nttdata.transactionservice.transactionservice.dto;

import lombok.Data;

@Data
public class DepositDTO {

    private Long idAccount;
    private Double amount;
    private String userCreation;
}
