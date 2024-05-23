package com.nttdata.clientservice.clientservice.repository;

import com.nttdata.clientservice.clientservice.entity.PersonalClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalClientRepository extends JpaRepository<PersonalClientEntity, Long> {
}
