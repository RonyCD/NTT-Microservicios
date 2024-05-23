
package com.nttdata.creditservice.creditservice.entity;
public class TypeAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INT_ID_TYPE_CREDIT")
    private Long id;

    @Column(name = "VCH_CREDIT_CODE", nullable = false)
    private String creditCode;

    @Column(name = "VCH_CREDIT_NAME", nullable = false)
    private String typeCreditName;

}