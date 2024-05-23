package com.nttdata.clientservice.clientservice.service.impl;

import com.nttdata.clientservice.clientservice.entity.BusinessClientEntity;
import com.nttdata.clientservice.clientservice.repository.BusinessClientRepository;
import com.nttdata.clientservice.clientservice.service.BusinessClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessClientServiceImpl implements BusinessClientService {

    @Autowired
    private BusinessClientRepository businessClientRepository;

    @Override
    public List<BusinessClientEntity> listAllBusinessClients() {
        return businessClientRepository.findAll();
    }

    @Override
    public BusinessClientEntity getBusinessClientById(Long id) {
        return businessClientRepository.getById(id);
    }

    @Override
    public BusinessClientEntity createdBusinessClient(BusinessClientEntity businessClient) {
        BusinessClientEntity newBusinessClient = businessClientRepository.save(businessClient);
        return newBusinessClient;
    }
}
