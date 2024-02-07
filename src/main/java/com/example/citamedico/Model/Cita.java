package com.example.citamedico.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
@Data
@Entity
@Table(name = "citas")
public class Cita {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "pacienteId")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medicoId")
    private Medico medico;

    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

    @Column
    @Temporal(TemporalType.TIME)
    private LocalTime hora;
    
    @Column
    private String motivo;
    

}
