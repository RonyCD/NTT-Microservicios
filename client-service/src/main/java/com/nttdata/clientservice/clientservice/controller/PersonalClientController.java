package com.nttdata.clientservice.clientservice.controller;

import com.nttdata.clientservice.clientservice.entity.ClientEntity;
import com.nttdata.clientservice.clientservice.entity.PersonalClientEntity;
import com.nttdata.clientservice.clientservice.service.PersonalClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/personal")
public class PersonalClientController {

    @Autowired
    private PersonalClientService personalClientService;

    @GetMapping("/all")
    public ResponseEntity<List<PersonalClientEntity>> listAllPersonalClients(){
        List<PersonalClientEntity> listPersonalClient = personalClientService.listAllPersonalClients();
        if(listPersonalClient.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listPersonalClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalClientEntity> getPersonalClientById(@PathVariable("id") long id){
        PersonalClientEntity personalById = personalClientService.getPersonalClientById(id);
        if(personalById == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personalById);
    }


    @PostMapping("/new")
    public ResponseEntity<PersonalClientEntity> createPersonalClient(@RequestBody PersonalClientEntity personalClient) {

        PersonalClientEntity newPersonalClient = personalClientService.createdPersonalClient(personalClient);
        if (newPersonalClient == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok(newPersonalClient);
    }

}
