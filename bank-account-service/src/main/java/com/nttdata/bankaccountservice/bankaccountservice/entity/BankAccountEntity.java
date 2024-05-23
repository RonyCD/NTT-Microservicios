package com.nttdata.bankaccountservice.bankaccountservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "BankAccountEntity")
@Table(name = "tb_bank_account")
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INT_ID_BANK_ACCOUNT")
    private Long id = 0L;

    @Column(name = "INT_ID_CLIENT", nullable = false)
    private Long idClient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_ID_TYPE_ACCOUNT", nullable = false)
    private TypeAccountEntity typeAccount;

    @Column(name = "VCH_NUM_ACCOUNT")
    private String numAccount;

    @Column(name = "DOU_OPENING_AMOUNT")
    private Double openingAmount;

    @Column(name = "DOU_BALANCE")
    private Double balance;

    @Column(name = "DT_OPENING_DATE")
    @Builder.Default
    private LocalDateTime openingDate = LocalDateTime.now();;

    @Column(name = "VCH_STATUS")
    @Builder.Default
    private String status = "active";

    @Column(name = "VCH_USER_CREATION")
    @Builder.Default
    private String userCreation = "ADMIN";

    @Column(name = "VCH_USER_MODIFICATION")
    private String userModification;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "DT_DATE_CREATION")
    @Builder.Default
    private LocalDateTime dateCreation = LocalDateTime.now();

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "DT_DATE_MODIFICATION")
    private LocalDateTime dateModification;


}
