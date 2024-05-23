package com.nttdata.clientservice.clientservice.repository;

import com.nttdata.clientservice.clientservice.entity.BusinessClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessClientRepository extends JpaRepository<BusinessClientEntity, Long> {
}
