package com.riwi.apirest.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.riwi.apirest.entity.Entidad;
import com.riwi.apirest.service.service_abstracto.IService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/event")
@AllArgsConstructor
public class EventoController {
  
  @Autowired
  private final IService eventoService;

  @GetMapping
  public ResponseEntity<List<Entidad>> getAll() {
    return ResponseEntity.ok(this.eventoService.getAll());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Entidad> findById(@PathVariable String id) {
    return ResponseEntity.ok(this.eventoService.findById(id));
  }
  
  @PostMapping
  public ResponseEntity<Entidad> insert(@RequestBody Entidad ojbEntidad) {
    return ResponseEntity.ok(this.eventoService.save(ojbEntidad));
  }
  
  @PutMapping(path = "/{id}")
  public ResponseEntity<Entidad> update(@PathVariable String id, @RequestBody Entidad objEntidad) {
    return ResponseEntity.ok(this.eventoService.update(id, objEntidad));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    this.eventoService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
