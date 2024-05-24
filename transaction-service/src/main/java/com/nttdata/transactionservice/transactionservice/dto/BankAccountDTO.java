package com.nttdata.transactionservice.transactionservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nttdata.transactionservice.transactionservice.entity.TypeAccountEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class BankAccountDTO {


    private Long idClient;
    private TypeAccountEntity typeAccount;
    private String numAccount;
    private Double openingAmount;
    private Double balance;

}
