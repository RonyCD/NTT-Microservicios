package com.nttdata.bankaccountservice.bankaccountservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "BankAccountEntity")
@Table(name = "TB_BANKACCOUNT")
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INT_ID_BANKACCOUNT")
    private Long id = 0L;

    @Column(name = "INT_ID_CLIENT")
    private Long idClient;

    @Column(name = "VCH_TYPE_ACCOUNT")
    @Enumerated(EnumType.STRING)
    private TypeAccount typeAccount;

    @Column(name = "VCH_NUMBER_ACCOUNT")
    private String numberAccount;

    @Column(name = "DOU_BALANCE")
    private Double balance;

    @Column(name = "DOU_AMOUNT_OPENING")
    private Double amountOpening;

    @Column(name = "DOU_COMMISSION_MAINT")
    private Double comissionMaintenance;

    @Column(name = "VCH_MOVEMENT_MONTHLY")
    private String movementMonthly;

    @Column(name = "DT_DATE_OPENING")
    private LocalDateTime dateOpening = LocalDateTime.now();

    @Column(name = "VCH_STATUS")
    @Builder.Default
    private String status = "active";

    @Column(name = "VCH_USER_CREATION")
    private String userCreation = "ADMIN";

    @Column(name = "VCH_USER_MODIFICATION")
    private String userModification;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "DT_DATE_CREATION")
    private LocalDateTime dateCreation = LocalDateTime.now();

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "DT_DATE_MODIFICATION")
    private LocalDateTime dateModification;


    public enum TypeAccount {
        CTA_AHORRO,
        CTA_CORRIENTE,
        PLAZO_FIJO,
    }
}
