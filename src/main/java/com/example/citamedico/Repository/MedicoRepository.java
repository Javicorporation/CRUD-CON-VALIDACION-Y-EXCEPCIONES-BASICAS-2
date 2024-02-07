package com.example.citamedico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.citamedico.Model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
