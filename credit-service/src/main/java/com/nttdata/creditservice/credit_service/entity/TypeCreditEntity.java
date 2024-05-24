
package com.nttdata.creditservice.creditservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity(name = "TypeAccountEntity")
@Table(name = "TB_TYPE_CREDIT")
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeCreditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INT_ID_TYPE_CREDIT")
    private Long id;

    @Column(name = "VCH_CREDIT_CODE", nullable = false)
    private String creditCode;

    @Column(name = "VCH_CREDIT_NAME", nullable = false)
    private String typeCreditName;

}