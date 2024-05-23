package com.nttdata.clientservice.clientservice.repository;

import com.nttdata.clientservice.clientservice.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByNumberDocument(int numberDocument);
}
