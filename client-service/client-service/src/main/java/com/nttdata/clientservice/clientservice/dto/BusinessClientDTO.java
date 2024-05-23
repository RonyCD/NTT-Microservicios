package com.nttdata.clientservice.clientservice.dto;

import com.nttdata.clientservice.clientservice.entity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessClientDTO {

    private Long id;

    private String bussinesName;

    private String address;

    private String phone;

    private String email;

    private String typeDocument;

    private String numberDocument;

    private ClientEntity.TypeClient typeClient;

}
