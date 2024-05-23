package com.nttdata.clientservice.clientservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "ClientEntity")
@Table(name = "TB_CLIENT")
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INT_ID_CLIENT")
    private Long id = 0L;

    @Column(name = "VCH_BUSINESS_NAME")
    private String bussinesName;

    @Column(name = "VCH_NAME")
    private String name;

    @Column(name = "VCH_SURNAME")
    private String surname;

    @Column(name = "VCH_SEX")
    private String sex;

    @Column(name = "VCH_ADDRESS")
    private String address;

    @Column(name = "VCH_CELLPHONE")
    private String cellphone;

    @Column(name = "VCH_PHONE")
    private String phone;

    @Column(name = "VCH_EMAIL")
    private String email;

    @Column(name = "VCH_TYPE_DOCUMENT")
    private String typeDocument;

    @Column(name = "VCH_NUM_DOCUMENT")
    private String numberDocument;

    @Column(name = "VCH_TYPE_CLIENT")
    @Enumerated(EnumType.STRING)
    private TypeClient typeClient;

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


    public enum TypeClient {
        PERSONAL,
        BUSINESS
    }
}


