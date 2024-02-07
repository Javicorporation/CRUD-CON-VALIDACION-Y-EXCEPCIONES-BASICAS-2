package com.example.citamedico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.citamedico.Model.Paciente;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
}
