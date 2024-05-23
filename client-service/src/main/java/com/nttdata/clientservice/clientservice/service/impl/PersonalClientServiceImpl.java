package com.nttdata.clientservice.clientservice.service.impl;

import com.nttdata.clientservice.clientservice.entity.PersonalClientEntity;
import com.nttdata.clientservice.clientservice.repository.PersonalClientRepository;
import com.nttdata.clientservice.clientservice.service.PersonalClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalClientServiceImpl implements PersonalClientService {

    @Autowired
    private PersonalClientRepository personalClientRepository;

    @Override
    public List<PersonalClientEntity> listAllPersonalClients() {
        return personalClientRepository.findAll();
    }

    @Override
    public PersonalClientEntity getPersonalClientById(Long id) {
        return personalClientRepository.getById(id);
    }

    @Override
    public PersonalClientEntity createdPersonalClient(PersonalClientEntity personalClient) {
        PersonalClientEntity newPersonalClient = personalClientRepository.save(personalClient);
        return newPersonalClient;
    }
}
