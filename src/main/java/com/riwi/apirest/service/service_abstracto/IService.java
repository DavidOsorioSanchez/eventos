package com.riwi.apirest.service.service_abstracto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.riwi.apirest.entity.Entidad;

public interface IService {
  
  public Page<Entidad> getAllByPages(int page, int size);
  
  public Entidad save(Entidad entidad);

  public Entidad findById(String id);

  public void delete(String id);

  public Entidad update(String id, Entidad objEntidad);
  
}
