package com.example.citamedico.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.citamedico.Model.Cita;
import com.example.citamedico.Model.Medico;
import com.example.citamedico.Model.Paciente;
import com.example.citamedico.Model.Valid.Error;
import com.example.citamedico.Service.CitaService;
import com.example.citamedico.Util.ResourcesNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Rest")
public class CitaController {

    @Autowired
    private CitaService citaService;

    /* CONTROLLER CITAS */

    @GetMapping("/citas")
    public ResponseEntity <?> getAllCita(){
        List<Cita> citas = citaService.findAllCita(); 
        if(citas.isEmpty()){
            throw new ResourcesNotFoundException("no existen medicos registrados");
        }     
        return ResponseEntity.ok(citas); 
    }

    @GetMapping("/cita/{id}")
    public ResponseEntity <?> getByIdCita(@PathVariable("id") long id){
        Cita traerUno = citaService.findByIdCita(id);
        if(traerUno == null){
            throw new ResourcesNotFoundException("el cliente " + id +" no existe, no fue encontrado");
        }
        return ResponseEntity.ok(traerUno); 
    }

    @PostMapping("/cita")
    public ResponseEntity<?> saveCita(@Valid @RequestBody Cita cita,BindingResult result){
        if(result.hasErrors()){
            List<String> message = result.getAllErrors().stream().map(ObjectError :: getDefaultMessage).collect(Collectors.toList());
            String errorMessage = String.join(", ", message);
            return ResponseEntity.badRequest().body(new Error("validation",errorMessage));
        }
        Cita newCita = citaService.saveCita(cita);
        return ResponseEntity.ok(newCita);
    }

    @DeleteMapping("/cita/{id}")
    public ResponseEntity<?> deleteCita(@PathVariable("id") long id){
        citaService.deleteCita(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/cita/{id}")
    public ResponseEntity<?> updateCita(@PathVariable("id") long id, @RequestBody Cita cita){
        Cita actualizarCurso =citaService.updateCita(id ,cita);
        if(actualizarCurso != null){
            return ResponseEntity.ok(actualizarCurso);
        }else{
            throw new ResourcesNotFoundException("el cliente " + id +" a actualizar no existe, no fue encontrado");
        }
    }

    /* CONTROLLER MEDICO */


    @GetMapping("/medicos")
    public ResponseEntity <?> getAllMedico(){
        List<Medico>medicos = citaService.findAllMedico();
        if(medicos.isEmpty()){
            throw new ResourcesNotFoundException("no existen medicos registrados");
        }     
        return ResponseEntity.ok(medicos); 
    }

    @GetMapping("/medico/{id}")
    public ResponseEntity <?> getByIdMedico(@PathVariable("id") long id){
        Medico traerUno = citaService.findByIdMedico(id);
        if(traerUno == null){
            throw new ResourcesNotFoundException("el medico " + id +" no existe, no fue encontrado");
        }
        return ResponseEntity.ok(traerUno); 
    }

    @PostMapping("/medico")
    public ResponseEntity<?> saveMedico(@Valid @RequestBody Medico medico,BindingResult result){
        if(result.hasErrors()){
            List<String> message = result.getAllErrors().stream().map(ObjectError :: getDefaultMessage).collect(Collectors.toList());
            String errorMessage = String.join(", ", message);
            return ResponseEntity.badRequest().body(new Error("validation",errorMessage));
        }
        Medico newMedico = citaService.saveMedico(medico);
        return ResponseEntity.ok(newMedico);
    }

    @DeleteMapping("/medico/{id}")
    public ResponseEntity<?> deleteMedico(@PathVariable("id") long id){
        citaService.deleteMedico(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/medico/{id}")
    public ResponseEntity<?> updateMedico(@PathVariable("id") long id, @RequestBody Medico medico){
        Medico actualizarMedico =citaService.updateMedico(id ,medico);
        if(actualizarMedico != null){
            return ResponseEntity.ok(actualizarMedico);
        }else{
            throw new ResourcesNotFoundException("el medico " + id +" a actualizar no existe, no fue encontrado");
        }
    }



    /* CONTROLLER PACIENTES */

    

    @GetMapping("/pacientes")
    public ResponseEntity <?> getAllCCita(){
        List<Paciente> pacientes = citaService.findAllPaciente();
        if(pacientes.isEmpty()){
            throw new ResourcesNotFoundException("no existen pacientes registrados");
        }     
        return ResponseEntity.ok(pacientes); 
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity <?> getByIdPaciente(@PathVariable("id") long id){
    Paciente traerUno = citaService.findByIdPaciente(id);
        if(traerUno == null){
            throw new ResourcesNotFoundException("el paciente " + id +" no existe, no fue encontrado");
        }
        return ResponseEntity.ok(traerUno); 
    }

    @PostMapping("/paciente")
    public ResponseEntity<?> savPaciente(@Valid @RequestBody Paciente paciente,BindingResult result){
        if(result.hasErrors()){
            List<String> message = result.getAllErrors().stream().map(ObjectError :: getDefaultMessage).collect(Collectors.toList());
            String errorMessage = String.join(", ", message);
            return ResponseEntity.badRequest().body(new Error("validation",errorMessage));
        }
        Paciente newPaciente = citaService.savePaciente(paciente);
        return ResponseEntity.ok(newPaciente);
    }

    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable("id") long id){
        citaService.deletePaciente(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/paciente/{id}")
    public ResponseEntity<?> updatePaciente(@PathVariable("id") long id, @RequestBody Paciente paciente){
    Paciente actualizarPaciente = citaService.updatePaciente(id , paciente);
        if(actualizarPaciente != null){
            return ResponseEntity.ok(actualizarPaciente);
        }else{
            throw new ResourcesNotFoundException("el paciente " + id +" a actualizar no existe, no fue encontrado");
        }
    }


    /* METODOS ESPECIALES */

    @GetMapping("/citas/paciente/{pacienteId}")
    public List<Cita> findByPacienteId(@PathVariable Long pacienteId) {
        return citaService.findByPacienteId(pacienteId);
    }

    @GetMapping("/citas/medico/{medicoId}")
    public List<Cita> findByMedicoId(@PathVariable Long medicoId) {
        return citaService.findByMedicoId(medicoId);
    }
    

}
