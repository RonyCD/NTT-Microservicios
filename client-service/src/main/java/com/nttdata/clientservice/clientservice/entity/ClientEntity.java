package com.nttdata.clientservice.clientservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;



@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Data
public class ClientEntity {

    @Column(name = "VCH_ADDRESS")
    private String address;

    @Column(name = "VCH_EMAIL")
    private String email;

    @Column(name = "VCH_TYPE_DOCUMENT")
    @Enumerated(EnumType.STRING)
    private TypeDocument typeDocument;

    @Column(name = "VCH_NUM_DOCUMENT")
    private String numDocument;

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

    public enum TypeDocument {
        DNI,
        RUC
    }

}