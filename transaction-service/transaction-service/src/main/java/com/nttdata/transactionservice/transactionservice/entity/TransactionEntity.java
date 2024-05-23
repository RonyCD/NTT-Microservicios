package com.nttdata.transactionservice.transactionservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "TransactionEntity")
@Table(name = "TB_TRANSACTION")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INT_ID_TRANSACTION")
    private Long id = 0L;

    @Column(name = "INT_ID_BANK_ACCOUNT")
    private Long idBankAccount;











}
