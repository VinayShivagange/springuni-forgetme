package com.springuni.forgetme.datahandler.service;

import com.springuni.forgetme.core.model.DataHandlerRegistry;
import com.springuni.forgetme.core.model.EntityNotFoundException;
import com.springuni.forgetme.core.orm.BaseRepository;
import com.springuni.forgetme.datahandler.model.DataHandler;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "dataHandlers", collectionResourceRel = "dataHandlers")
public interface DataHandlerRepository
    extends BaseRepository<DataHandler, UUID>, DataHandlerRegistry {

  @Override
  @RestResource
  Optional<DataHandler> findById(UUID id);

  Optional<DataHandler> findByName(String name);

  @Override
  @RestResource
  DataHandler save(DataHandler dataHandler);

  @Override
  default UUID register(String name) {
    return findByName(name).orElseGet(() -> save(new DataHandler(name))).getId();
  }

  @Override
  default String lookup(UUID id) {
    return findById(id)
        .map(DataHandler::getName)
        .orElseThrow(() -> new EntityNotFoundException("id", id));
  }

}
