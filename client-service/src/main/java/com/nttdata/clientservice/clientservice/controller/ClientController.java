package com.nttdata.clientservice.clientservice.controller;

import com.nttdata.clientservice.clientservice.entity.BusinessClientEntity;
import com.nttdata.clientservice.clientservice.entity.ClientEntity;
import com.nttdata.clientservice.clientservice.entity.PersonalClientEntity;
import com.nttdata.clientservice.clientservice.repository.BusinessClientRepository;
import com.nttdata.clientservice.clientservice.repository.PersonalClientRepository;
import com.nttdata.clientservice.clientservice.service.BusinessClientService;
import com.nttdata.clientservice.clientservice.service.PersonalClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private BusinessClientService businessClientService;

    @Autowired
    private PersonalClientService personalClientService;

    @GetMapping
    public ResponseEntity<List<ClientEntity>> listAllClients(){
        List<ClientEntity> allClients = new ArrayList<>();

        List<BusinessClientEntity> businessClients = businessClientService.listAllBusinessClients();
        allClients.addAll(businessClients);

        List<PersonalClientEntity> personalClients = personalClientService.listAllPersonalClients();
        allClients.addAll(personalClients);

        if(allClients.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allClients);
    }

}
