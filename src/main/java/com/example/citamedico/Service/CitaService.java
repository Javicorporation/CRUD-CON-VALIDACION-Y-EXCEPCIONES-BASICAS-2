package com.example.citamedico.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.citamedico.Model.Cita;
import com.example.citamedico.Model.Medico;
import com.example.citamedico.Model.Paciente;
import com.example.citamedico.Repository.CitaRepository;
import com.example.citamedico.Repository.MedicoRepository;
import com.example.citamedico.Repository.PacienteRepository;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;


    /* SERVICE CITAS */
    public List<Cita> findAllCita(){
        return citaRepository.findAll();
    }

    public Cita findByIdCita(long id){
        return citaRepository.findById(id).orElse(null);
    }

    public Cita saveCita(Cita cita){
        return citaRepository.save(cita);
    }

    public void deleteCita(long id){
        citaRepository.deleteById(id);
    } 

    public Cita updateCita(long id, Cita citaUpdate){
        Cita citaEncontrada = findByIdCita(id);
        if(citaEncontrada != null){
            citaEncontrada.setMedico(citaUpdate.getMedico());
            citaEncontrada.setPaciente(citaUpdate.getPaciente());
            citaEncontrada.setFecha(citaUpdate.getFecha());
            citaEncontrada.setHora(citaUpdate.getHora());
            citaEncontrada.setMotivo(citaUpdate.getMotivo());
            return citaRepository.save(citaEncontrada);
        }else{
            return null;
        }
    }


    /* CERVICE MEDICO */

    @Autowired
    private MedicoRepository medicoRepository;


    public List<Medico> findAllMedico(){
        return medicoRepository.findAll();
    }

    public Medico findByIdMedico(long id){
        return medicoRepository.findById(id).orElse(null);
    }

    public Medico saveMedico(Medico medico){
        return medicoRepository.save(medico);
    }

    public void deleteMedico(long id){
        medicoRepository.deleteById(id);
    } 

    public Medico updateMedico(long id, Medico medicoUpdate){
        Medico medicoEncontrado = findByIdMedico(id);
        if(medicoEncontrado != null){
            medicoEncontrado.setNombre(medicoUpdate.getNombre());
            medicoEncontrado.setHorario(medicoUpdate.getHorario());
            medicoEncontrado.setEspecialidad(medicoUpdate.getEspecialidad());

            return medicoRepository.save(medicoEncontrado);
        }else{
            return null;
        }
    }

    /* SERVICE PACIENTE */

    @Autowired
    private PacienteRepository pacienteRepository;


    public List<Paciente> findAllPaciente(){
        return pacienteRepository.findAll();
    }

    public Paciente findByIdPaciente(long id){
        return pacienteRepository.findById(id).orElse(null);
    }

    public Paciente savePaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public void deletePaciente(long id){
        pacienteRepository.deleteById(id);
    } 

    public Paciente updatePaciente(long id, Paciente pacienteUpdate){
        Paciente pacienteEncontrado = findByIdPaciente(id);
        if(pacienteEncontrado != null){
            pacienteEncontrado.setNombre(pacienteUpdate.getNombre());
            pacienteEncontrado.setFechaNacimiento(pacienteUpdate.getFechaNacimiento());
            pacienteEncontrado.setGenero(pacienteUpdate.getGenero());

            return pacienteRepository.save(pacienteEncontrado);            
        }else{
            return null;
        }
    }

    

    /* METODOS ESPECIALES */

    public List<Cita> findByPacienteId(Long pacienteId) {
        List<Cita> citas = citaRepository.findByPacienteId(pacienteId);
        for (Cita cita : citas) {
            cita.getPaciente().getNombre(); 
            cita.getPaciente().getGenero();
            cita.getPaciente().getFechaNacimiento();
        }
        return citas;
    }

    public List<Cita> findByMedicoId(Long medicoId) {
        List<Cita> citas = citaRepository.findByMedicoId(medicoId);
        for (Cita cita : citas) {
            cita.getMedico().getNombre();
            cita.getMedico().getEspecialidad();
            cita.getMedico().getHorario();
        }
        return citas;
    }


}
