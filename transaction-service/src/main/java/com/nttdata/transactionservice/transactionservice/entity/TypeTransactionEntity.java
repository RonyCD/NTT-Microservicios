package com.nttdata.transactionservice.transactionservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "TypeTransactionEntity")
@Table(name = "TB_TYPE_TRANSACTION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INT_ID_TYPE_TRANSACTION")
    private Long id = 0L;

    @Column(name = "VCH_TRANSACTION_CODE")
    private String transactionCode;

    @Column(name = "VCH_TRANSACTION_NAME")
    private String transactionName;

}
