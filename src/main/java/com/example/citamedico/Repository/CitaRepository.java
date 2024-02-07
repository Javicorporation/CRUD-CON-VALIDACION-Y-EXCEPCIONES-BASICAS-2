package com.example.citamedico.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.citamedico.Model.Cita;


@Repository
public interface CitaRepository extends JpaRepository<Cita, Long>{
    List<Cita> findByPacienteId(long pacienteId);
    List<Cita> findByMedicoId(long medicoId);

}
