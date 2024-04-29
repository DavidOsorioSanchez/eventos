package com.riwi.apirest.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.riwi.apirest.entity.Entidad;
import com.riwi.apirest.service.service_abstracto.IService;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/v1/event")
@AllArgsConstructor
public class EventoController {
  @Autowired
  private final IService eventoService;


  @GetMapping
  public ResponseEntity<Page<Entidad>> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size){
    return ResponseEntity.ok(this.eventoService.getAllByPages(page - 1, size));
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Entidad> findById(@PathVariable String id) {
    return ResponseEntity.ok(this.eventoService.findById(id));
  }
  
  @PostMapping
  public ResponseEntity<Entidad> insert(@RequestBody Entidad ojbEntidad) {
    if (fechaRe(ojbEntidad.getFecha()) && totalCapa(ojbEntidad.getCapacidad())) {
      return ResponseEntity.ok(this.eventoService.save(ojbEntidad));
    }else{
      return ResponseEntity.badRequest().build();
    }

  }
  
  @PutMapping(path = "/{id}")
  public ResponseEntity<Entidad> update(@PathVariable String id, @RequestBody Entidad objEntidad) {
    if (fechaRe(objEntidad.getFecha()) && totalCapa(objEntidad.getCapacidad())) {
      return ResponseEntity.ok(this.eventoService.update(id, objEntidad));
    }else{
      return ResponseEntity.badRequest().build();
    }
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    this.eventoService.delete(id);
    return ResponseEntity.noContent().build();
  }

  public boolean fechaRe(LocalDate fecha){
    LocalDate hoy = LocalDate.now();
    if (fecha.isBefore(hoy)) {
      return false;

    } else {
      return true;
    }
  }

  public boolean totalCapa(int capacidad){
    if (capacidad>0) return true;
    return false;
  }

}
