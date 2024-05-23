package com.nttdata.clientservice.clientservice.service;

import com.nttdata.clientservice.clientservice.entity.PersonalClientEntity;

import java.util.List;

public interface PersonalClientService {

    public List<PersonalClientEntity> listAllPersonalClients();

    public PersonalClientEntity getPersonalClientById(Long id);

    public PersonalClientEntity createdPersonalClient (PersonalClientEntity personalClient);

}
