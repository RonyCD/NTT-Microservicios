package com.nttdata.clientservice.clientservice.entity.bankaccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountEntity {
    private Long id;
    private Long idClient;
    private TypeAccountEntity typeAccount;
    private String numAccount;
    private Double openingAmount;
    private Double balance;
    private LocalDateTime openingDate;
    private String status;
    private String userCreation;
    private String userModification;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;

}
