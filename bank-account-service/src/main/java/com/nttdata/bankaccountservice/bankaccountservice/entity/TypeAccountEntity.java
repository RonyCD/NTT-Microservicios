package com.nttdata.bankaccountservice.bankaccountservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "TypeAccountEntity")
@Table(name = "tb_type_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INT_ID_TYPE_ACCOUNT")
    private Long id;

    @Column(name = "VCH_ACCOUNT_CODE", nullable = false)
    private String accountCode;

    @Column(name = "VCH_ACCOUNT_TYPE_NAME", nullable = false)
    private String typeAccountName;

    @Column(name = "INT_MOVEMENT_LIMIT")
    private Integer movementLimit;

    @Column(name = "DOU_COMISSION_MANT")
    private Double comissionMant;
}
