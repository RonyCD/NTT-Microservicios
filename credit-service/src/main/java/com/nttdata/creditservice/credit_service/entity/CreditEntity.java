package com.nttdata.creditservice.creditservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "CreditEntity")
@Table(name = "TB_CREDIT")
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INT_ID_CREDIT")
    private Long id = 0L;

    @Column(name = "INT_ID_CLIENT", nullable = false)
    private Long idClient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_ID_TYPE_CREDIT", nullable = false)
    private TypeCreditEntity typeCredit;

    @Column(name = "DOU_AMOUNT")
    private Double douAmount;

    @Column(name = "DOU_INTERES_RATE")
    private Double douInteresRate;

    @Column(name = "DT_GRANT_DATE")
    @Builder.Default
    private LocalDateTime grantDate = LocalDateTime.now();;

    @Column(name = "INT_INSTALLMENTS", nullable = false)
    private Integer intInstallments;

    @Column(name = "VCH_STATUS", nullable = false)
    private String vchStatus;


}