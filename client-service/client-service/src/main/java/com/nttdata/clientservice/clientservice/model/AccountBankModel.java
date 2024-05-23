package com.nttdata.clientservice.clientservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountBankModel {

    private TypeAccount typeAccount;
    private String numberAccount;
    private Double balance;
    private Double amountOpening;
    private Double comissionMaintenance;
    private String movementMonthly;
    private String dateOpening;
    private String status;
    private String userCreation;
    private String userModification;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;

    private Long idClient;

    public enum TypeAccount {
        CTA_AHORRO,
        CTA_CORRIENTE,
        PLAZO_FIJO,
    }
}
