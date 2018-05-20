package com.gemmano.dr.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gemmano.dr.entities.Registry;

@Repository
public interface DeviceRepo extends CrudRepository<Registry, Long> {

}
