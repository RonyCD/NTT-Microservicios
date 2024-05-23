package com.nttdata.clientservice.clientservice.controller;

import com.nttdata.clientservice.clientservice.entity.BusinessClientEntity;
import com.nttdata.clientservice.clientservice.entity.PersonalClientEntity;
import com.nttdata.clientservice.clientservice.service.BusinessClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/business")
public class BusinessClientController {

    @Autowired
    private BusinessClientService businessClientService;

    @GetMapping("/all")
    public ResponseEntity<List<BusinessClientEntity>> listAllBusinessClients(){
        List<BusinessClientEntity> listBusinessClient = businessClientService.listAllBusinessClients();
        if(listBusinessClient.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listBusinessClient);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BusinessClientEntity> getBusinessClientById(@PathVariable("id") long id){
        BusinessClientEntity businessById = businessClientService.getBusinessClientById(id);
        if(businessById == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(businessById);
    }


    @PostMapping("/new")
    public ResponseEntity<BusinessClientEntity> createBusinessClient(@RequestBody BusinessClientEntity businessClient) {

        BusinessClientEntity newBusinessClient = businessClientService.createdBusinessClient(businessClient);
        if (newBusinessClient == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok(newBusinessClient);
    }

}
