package com.prog.medicalAppointment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.medicalAppointment.Entity.Patient;
import com.prog.medicalAppointment.Repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepo;
	
	 public Patient addPatient(Patient patient){
	       
	        return patientRepo.save(patient);
	    }

	    

	    public List<Patient> displayAll(){

	        return patientRepo.findAll();
	    }

	   
	    public Patient getPatientById(int Id) {
	        Optional<Patient> patientId = patientRepo.findById(Id);
	        if(patientId.isPresent()){
	            return patientId.get();
	        }else{
	            throw new RuntimeException("Patient not found-id: " + Id);
	        }

	    }

	    public void updatePatient(int Id, Patient patient) {
	        Optional<Patient> existingPatient = patientRepo.findById(Id);
	        if (existingPatient.isPresent()) {            
	        	existingPatient.get().setPatientName(patient.getPatientName());
	        	existingPatient.get().setAge(patient.getAge());
	        	existingPatient.get().setGender(patient.getGender());
	        	existingPatient.get().setContact(patient.getContact());
	        	existingPatient.get().setAddress(patient.getAddress());
	        	existingPatient.get().setMedicalHistory(patient.getMedicalHistory());
	        	

	        	patientRepo.save(existingPatient.get());
	        }

	    }

	    
	    public void deletePatientById(int Id){

	    	patientRepo.deleteById(Id);        
	    }
	
}
