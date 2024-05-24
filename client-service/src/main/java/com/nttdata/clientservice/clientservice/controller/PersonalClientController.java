package com.nttdata.clientservice.clientservice.controller;

import com.nttdata.clientservice.clientservice.dto.BankAccountDTO;
import com.nttdata.clientservice.clientservice.entity.ClientEntity;
import com.nttdata.clientservice.clientservice.entity.PersonalClientEntity;
import com.nttdata.clientservice.clientservice.entity.bankaccount.BankAccountEntity;
import com.nttdata.clientservice.clientservice.feignclient.BankAccountFeignClient;
import com.nttdata.clientservice.clientservice.service.PersonalClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client/personal")
public class PersonalClientController {

    @Autowired
    private PersonalClientService personalClientService;

    @Autowired
    private BankAccountFeignClient bankAccountFeignClient;


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


    @PostMapping("/new1")
    public ResponseEntity<PersonalClientEntity> createPersonalClient1(@RequestBody PersonalClientEntity personalClient) {

        PersonalClientEntity newPersonalClient = personalClientService.createdPersonalClient(personalClient);
        if (newPersonalClient == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok(newPersonalClient);
    }



    @PostMapping("/new2")
    public ResponseEntity<PersonalClientEntity> createPersonalClient2(@RequestBody PersonalClientEntity personalClient) {
        PersonalClientEntity newPersonalClient = personalClientService.createdPersonalClient(personalClient);
        if (newPersonalClient == null) {
            return ResponseEntity.status(500).build();
        }

        // Crear la cuenta bancaria para el nuevo cliente
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setIdClient(newPersonalClient.getId());
        bankAccountDTO.setTypeAccountCode("CA"); // Por ejemplo, cuenta de ahorro
        bankAccountDTO.setNumAccount("XX-25698"); // Método para generar el número de cuenta
        bankAccountDTO.setOpeningAmount(0.0);
        bankAccountDTO.setBalance(0.0);

        ResponseEntity<BankAccountEntity> bankAccountResponse = bankAccountFeignClient.createBankAccount(bankAccountDTO);
        if (!bankAccountResponse.getStatusCode().is2xxSuccessful()) {
            // Manejar el error en la creación de la cuenta bancaria si es necesario
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok(newPersonalClient);
    }


    @PostMapping("/new")
    public ResponseEntity<Map<String, Object>> createPersonalClient(@RequestBody Map<String, Object> personalClientWithAccountMap) {

        // Crear el cliente personal
        PersonalClientEntity personalClient = new PersonalClientEntity();
        personalClient.setAddress((String) personalClientWithAccountMap.get("address"));
        personalClient.setEmail((String) personalClientWithAccountMap.get("email"));
        personalClient.setTypeDocument(ClientEntity.TypeDocument.valueOf((String) personalClientWithAccountMap.get("typeDocument")));
        personalClient.setNumDocument((String) personalClientWithAccountMap.get("numDocument"));
        personalClient.setName((String) personalClientWithAccountMap.get("name"));
        personalClient.setSurname((String) personalClientWithAccountMap.get("surname"));
        personalClient.setCellphone((String) personalClientWithAccountMap.get("cellphone"));
        personalClient.setGender(PersonalClientEntity.Gender.valueOf((String) personalClientWithAccountMap.get("gender")));

        PersonalClientEntity newPersonalClient = personalClientService.createdPersonalClient(personalClient);
        if (newPersonalClient == null) {
            return ResponseEntity.status(500).build();
        }

        // Crear la cuenta bancaria usando el cliente recién creado
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setIdClient(newPersonalClient.getId());
        bankAccountDTO.setTypeAccountCode((String) personalClientWithAccountMap.get("typeAccountCode"));
        bankAccountDTO.setNumAccount((String) personalClientWithAccountMap.get("numAccount"));
        bankAccountDTO.setOpeningAmount((Double) personalClientWithAccountMap.get("openingAmount"));
        bankAccountDTO.setBalance((Double) personalClientWithAccountMap.get("balance"));

        ResponseEntity<BankAccountEntity> bankAccountResponse = bankAccountFeignClient.createBankAccount(bankAccountDTO);
        if (!bankAccountResponse.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.status(500).build();
        }

        // Construir la respuesta
        Map<String, Object> response = new HashMap<>();
        response.put("personalClient", newPersonalClient);
        response.put("bankAccount", bankAccountResponse.getBody());

        return ResponseEntity.ok(response);
    }



}
