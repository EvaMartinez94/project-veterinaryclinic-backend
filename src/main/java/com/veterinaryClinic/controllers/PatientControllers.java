package com.veterinaryClinic.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.veterinaryClinic.models.Patient;
import com.veterinaryClinic.models.PatientDTO;
import com.veterinaryClinic.services.PatientServices;

@RestController
@RequestMapping("/api/vc")
@CrossOrigin(origins = "*")
public class PatientControllers {

  @Autowired private PatientServices patientService;

    @PostMapping(path = "/patient")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient newPatient) {
      Patient patient = patientService.cretePatient(newPatient);
      return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/patient")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

  @GetMapping(path = "patient/{id}")
  public Optional<Patient> getPatientbyId(@PathVariable Long id) {
    return patientService.getPatientbyId(id);
  }

  @GetMapping(path = "/patient/tn/{tutorName}")
  public List<Patient> getByTutorName(@PathVariable String tutorName) {
    return patientService.getByTutorName(tutorName);
  }

  @GetMapping(path = "/patient/in/{identificationNumber}")
  public List<Patient> getByIdentificationNumber(@PathVariable Long identificationNumber) {
    return patientService.getByIdentificationNumber(identificationNumber);
  }
  @DeleteMapping(path = "/patient/{patient_id}")
    public void deletePatient(@PathVariable Long patient_id){
        patientService.deletePatient(patient_id);
  }

  @PutMapping(path ="/patient/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO) {
      patientService.updatePatient(id, patientDTO);
      return ResponseEntity.ok(patientDTO);
    }  
}
