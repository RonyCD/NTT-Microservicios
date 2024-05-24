package com.nttdata.transactionservice.transactionservice.entity;

import lombok.Data;

import javax.persistence.Column;

@Data
public class TypeAccountEntity {
    private String accountCode;
    private String typeAccountName;
    private Integer movementLimit;
    private Double comissionMant;
}
