package com.nttdata.clientservice.clientservice.dto;

import com.nttdata.clientservice.clientservice.entity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalClientDTO {

    private Long id;

    private String name;

    private String surname;

    private String sex;

    private String address;

    private String cellphone;

    private String email;

    private String typeDocument;

    private String numberDocument;

    private ClientEntity.TypeClient typeClient;

}
