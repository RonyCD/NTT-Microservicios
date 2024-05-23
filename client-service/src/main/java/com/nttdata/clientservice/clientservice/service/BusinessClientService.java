package com.nttdata.clientservice.clientservice.service;

import com.nttdata.clientservice.clientservice.entity.BusinessClientEntity;


import java.util.List;

public interface BusinessClientService {

    public List<BusinessClientEntity> listAllBusinessClients();

    public BusinessClientEntity getBusinessClientById(Long id);

    public BusinessClientEntity createdBusinessClient (BusinessClientEntity businessClient);
}
