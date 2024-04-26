package com.riwi.apirest.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.apirest.entity.Entidad;

@Repository
public interface repositorio extends JpaRepository<Entidad, String>{
 
}