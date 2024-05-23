package com.nttdata.clientservice.clientservice.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity(name="PersonalClientEntity")
@Table(name="tb_personal_client")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalClientEntity extends ClientEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INT_ID_CPERSONAL")
    private Long id = 0L;

    @Column(name = "VCH_NAME")
    private String name;

    @Column(name = "VCH_SURNAME")
    private String surname;

    @Column(name = "VCH_CELLPHONE")
    private String cellphone;

    @Column(name = "VCH_GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public enum Gender {
        Masculino,
        Femenino
    }

}

