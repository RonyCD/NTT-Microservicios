package com.nttdata.transactionservice.transactionservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "TransactionEntity")
@Table(name = "TB_TRANSACTION")
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INT_ID_TRANSACTION")
    private Long id = 0L;

    @Column(name = "INT_ID_BANK_ACCOUNT")
    private Long idBankAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_ID_TYPE_TRANSACTION", nullable = false)
    private TypeTransactionEntity typeTransaction;

    @Column(name = "VCH_SENDER_ACCOUNT")
    private String senderAccount;

    @Column(name = "VCH_DESTINATION_ACCOUNT")
    private String destinationAccount;

    @Column(name = "DOU_AMOUNT")
    private Double amount;

    @Column(name = "DT_DATE_OPERATION")
    private LocalDateTime dateOperation;

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
