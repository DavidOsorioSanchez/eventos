package com.riwi.apirest.service;

import java.util.List;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import com.riwi.apirest.entity.Entidad;
import com.riwi.apirest.reposiory.repositorio;
import com.riwi.apirest.service.service_abstracto.IService;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class reunionService implements IService {

  @Autowired
  private final repositorio objRepositorio;

  @Override
  public Entidad save(Entidad entidad) {
    return this.objRepositorio.save(entidad);
  }

  @Override
  public Entidad findById(String id) {
    return this.objRepositorio.findById(id).orElseThrow();
  }

  @Override
  public void delete(String id) {
    Entidad EncontrarEntidad = this.objRepositorio.findById(id).orElseThrow();
    this.objRepositorio.delete(EncontrarEntidad);
  }

  @Override
  public Entidad update(String id, Entidad objEntidad) {
    this.objRepositorio.findById(id).orElseThrow();
    objEntidad.setId(id);
    return this.objRepositorio.save(objEntidad);
  }

  @Override
  public Page<Entidad> getAllByPages(int page, int size) {
    if (page < 0) {page = 0;}
    Pageable objPageable = PageRequest.of(page, size);
    return this.objRepositorio.findAll(objPageable);
  }

}
