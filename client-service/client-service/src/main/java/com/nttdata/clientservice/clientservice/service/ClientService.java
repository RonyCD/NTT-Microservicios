package com.nttdata.clientservice.clientservice.service;

import com.nttdata.clientservice.clientservice.dto.BusinessClientDTO;
import com.nttdata.clientservice.clientservice.dto.PersonalClientDTO;
import com.nttdata.clientservice.clientservice.entity.ClientEntity;
import com.nttdata.clientservice.clientservice.model.AccountBankModel;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface ClientService {

    public List<ClientEntity> listAllClients();

    public ClientEntity getClientById(Long id);

    public PersonalClientDTO createdClientPersonal(PersonalClientDTO personalDTO);

    public BusinessClientDTO createdClientBusiness(BusinessClientDTO businessDTO);

    ClientEntity updateClientPersonal(ClientEntity clientEntity);

    ClientEntity updateClientBusiness(ClientEntity clientEntity);

    ClientEntity deleteClientPersonal(ClientEntity clientEntity);

    ClientEntity deleteClientBusiness(ClientEntity clientEntity);


    AccountBankModel newAccountOfClient(Long idClient, AccountBankModel accountBankModel);

    Map<String, Object> getAccountClients(Long idClient);
}

