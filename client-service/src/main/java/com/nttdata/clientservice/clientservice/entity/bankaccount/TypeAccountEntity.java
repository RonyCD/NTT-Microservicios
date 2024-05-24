package com.nttdata.clientservice.clientservice.entity.bankaccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeAccountEntity {
    private Long id;
    private String accountCode;
    private String typeAccountName;
    private Integer movementLimit;
    private Double comissionMant;
}
