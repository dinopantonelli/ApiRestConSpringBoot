package ar.dino.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.dino.model.Persona;

public interface PersonaDAO extends JpaRepository<Persona , Integer> {

    
}
