package com.riwi.apirest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entidad {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID) 
  private String id;
  private String nombre;
  private LocalDate fecha;
  private String ubicaccion;
  private int capacidad;

}
