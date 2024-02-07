package com.example.citamedico.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "medicos")
public class Medico {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nombre;

    @Column
    private String especialidad;

    @Column
    private String horario;

    public Medico(long id, String nombre, String especialidad, String horario) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.horario = horario;
    }

    public Medico() {
    }

}
