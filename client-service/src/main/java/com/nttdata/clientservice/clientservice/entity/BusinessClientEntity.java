package com.nttdata.clientservice.clientservice.entity;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity(name="BusinessClientEntity")
@Table(name="tb_business_client")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessClientEntity extends ClientEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INT_ID_CBUSINESS")
    private Long id = 0L;

    @Column(name = "VCH_BUSINESS_NAME")
    private String businessName;

    @Column(name = "VCH_PHONE")
    private String phone;

    @Column(name = "VCH_HOLDER")
    private String holder;

}
