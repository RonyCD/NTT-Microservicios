package com.nttdata.clientservice.clientservice.controller;

import com.nttdata.clientservice.clientservice.dto.BusinessClientDTO;
import com.nttdata.clientservice.clientservice.dto.PersonalClientDTO;
import com.nttdata.clientservice.clientservice.entity.ClientEntity;
import com.nttdata.clientservice.clientservice.model.AccountBankModel;
import com.nttdata.clientservice.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<ClientEntity>> listAllClients(){
        List<ClientEntity> listClients = clientService.listAllClients();
        if(listClients.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listClients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientEntity> getClient(@PathVariable("id") long id){
        ClientEntity client = clientService.getClientById(id);
        if(client == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @PostMapping("/personal")
    public ResponseEntity<PersonalClientDTO> createPersonalClient(@RequestBody PersonalClientDTO personalClientDTO) {

        PersonalClientDTO newClientPersonal = clientService.createdClientPersonal(personalClientDTO);
        if (newClientPersonal == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok(newClientPersonal);
    }

    @PostMapping("/business")
    public ResponseEntity<BusinessClientDTO> createBusinessClient(@RequestBody BusinessClientDTO businessClientDTO) {
        BusinessClientDTO newClientBusiness = clientService.createdClientBusiness(businessClientDTO);
        if (newClientBusiness == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok(newClientBusiness);
    }


    @PostMapping("/bank-acount/{idClient}")
    public ResponseEntity<AccountBankModel> saveAccountBankOfClient(@PathVariable("idClient") Long idClient, @RequestBody AccountBankModel accountBankModel){
        AccountBankModel newAccountOfClient = clientService.newAccountOfClient(idClient, accountBankModel);
        return ResponseEntity.ok(newAccountOfClient);
    }


    @GetMapping("/bank-account/client/{idClient}")
    public ResponseEntity<Map<String, Object>> listAccountBankClient(@PathVariable("idClient") Long idClient) {
        try {
            Map<String, Object> result = clientService.getAccountClients(idClient);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            // Manejo de excepciones
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error al obtener la cuenta del cliente.");
            errorResponse.put("message", e.getMessage()); // Opcional: puedes incluir el mensaje de la excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }


}
