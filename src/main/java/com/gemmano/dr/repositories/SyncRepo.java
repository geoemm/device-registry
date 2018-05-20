package com.gemmano.dr.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gemmano.dr.entities.Sync;

@Repository
public interface SyncRepo extends CrudRepository<Sync, Long> {

}
