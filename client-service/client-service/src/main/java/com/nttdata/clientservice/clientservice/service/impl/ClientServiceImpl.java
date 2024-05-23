package com.nttdata.clientservice.clientservice.service.impl;

import com.nttdata.clientservice.clientservice.dto.BusinessClientDTO;
import com.nttdata.clientservice.clientservice.dto.PersonalClientDTO;
import com.nttdata.clientservice.clientservice.entity.ClientEntity;
import com.nttdata.clientservice.clientservice.feignclient.BankAccountFeignClient;
import com.nttdata.clientservice.clientservice.model.AccountBankModel;
import com.nttdata.clientservice.clientservice.repository.ClientRepository;
import com.nttdata.clientservice.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BankAccountFeignClient bankAccountFeignClient;

    @Override
    public List<ClientEntity> listAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientEntity getClientById(Long id) {
        return clientRepository.getById(id);
    }

    @Override
    public PersonalClientDTO createdClientPersonal(PersonalClientDTO personalDTO) {
        ClientEntity newClientPersonal =  convertPersonalDTOMODEL(personalDTO);
        clientRepository.save(newClientPersonal);
        return personalDTO;
    }

    @Override
    public BusinessClientDTO createdClientBusiness(BusinessClientDTO businessDTO) {
        ClientEntity newClientBusiness = convertBusinessDTOMODEL(businessDTO);
        clientRepository.save(newClientBusiness);
        return businessDTO;
    }

    @Override
    public ClientEntity updateClientPersonal(ClientEntity clientEntity) {
        ClientEntity personalClient = getClientById(clientEntity.getId());
        if(personalClient == null){
            return null;
        }
        personalClient.setName(clientEntity.getName());
        personalClient.setSurname(clientEntity.getSurname());
        personalClient.setAddress(clientEntity.getAddress());
        personalClient.setCellphone(clientEntity.getCellphone());
        personalClient.setEmail(clientEntity.getEmail());

        return clientRepository.save(clientEntity);
    }


    @Override
    public ClientEntity updateClientBusiness(ClientEntity clientEntity) {
        ClientEntity personalBusiness = getClientById(clientEntity.getId());
        if(personalBusiness == null){
            return null;
        }

        personalBusiness.setBussinesName(clientEntity.getBussinesName());
        personalBusiness.setAddress(clientEntity.getAddress());
        personalBusiness.setPhone(clientEntity.getPhone());
        personalBusiness.setEmail(clientEntity.getEmail());

        return clientRepository.save(clientEntity);
    }

    @Override
    public ClientEntity deleteClientPersonal(ClientEntity clientEntity) {
        ClientEntity clientPersonal = getClientById(clientEntity.getId());
        if (clientPersonal == null) {
            return null;
        }
        clientPersonal.setStatus("inactive");
        return clientRepository.save(clientEntity);
    }

    @Override
    public ClientEntity deleteClientBusiness(ClientEntity clientEntity) {
        ClientEntity clientBusiness = getClientById(clientEntity.getId());
        if (clientBusiness == null) {
            return null;
        }
        clientBusiness.setStatus("inactive");
        return clientRepository.save(clientEntity);
    }

    @Override
    public AccountBankModel newAccountOfClient(Long idClient, AccountBankModel accountBankModel) {
        accountBankModel.setIdClient(idClient);
        AccountBankModel newAccountClient = bankAccountFeignClient.save(accountBankModel);
        return newAccountClient;
    }


    @Override
    public Map<String, Object> getAccountClients(Long idClient){
        Map<String, Object> result = new HashMap<>();
        ClientEntity client = clientRepository.findById(idClient).orElse(null);
        if(client == null){
            result.put("Client", "El cliente no existe");
            return result;
        }
        result.put("Client", client);

        List<AccountBankModel> bankAccount = bankAccountFeignClient.getAccountClients(idClient);
        if(bankAccount.isEmpty()) {
            result.put("AccountBank", "El cliente no tiene cuenta bancaria");
        }
        else{
            result.put("AccountBank", bankAccount);
        }

        return result;
    }


    private ClientEntity convertPersonalDTOMODEL(PersonalClientDTO personalDTO) {
        // TODO Auto-generated method stub
        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setId(personalDTO.getId());
        clientEntity.setName(personalDTO.getName());
        clientEntity.setSurname(personalDTO.getSurname());
        clientEntity.setSex(personalDTO.getSex());
        clientEntity.setAddress(personalDTO.getAddress());
        clientEntity.setCellphone(personalDTO.getCellphone());
        clientEntity.setEmail(personalDTO.getEmail());
        clientEntity.setTypeDocument(personalDTO.getTypeDocument());
        clientEntity.setNumberDocument(personalDTO.getNumberDocument());
        clientEntity.setTypeClient(personalDTO.getTypeClient());

        return clientEntity;
    }


    private ClientEntity convertBusinessDTOMODEL(BusinessClientDTO businessDTO) {
        // TODO Auto-generated method stub
        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setId(businessDTO.getId());
        clientEntity.setBussinesName(businessDTO.getBussinesName());
        clientEntity.setAddress(businessDTO.getAddress());
        clientEntity.setPhone(businessDTO.getPhone());
        clientEntity.setEmail(businessDTO.getEmail());
        clientEntity.setTypeDocument(businessDTO.getTypeDocument());
        clientEntity.setNumberDocument(businessDTO.getNumberDocument());
        clientEntity.setTypeClient(businessDTO.getTypeClient());

        return clientEntity;
    }

}

