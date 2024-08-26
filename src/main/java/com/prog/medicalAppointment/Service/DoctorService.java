package com.prog.medicalAppointment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.medicalAppointment.Entity.Doctor;
import com.prog.medicalAppointment.Repository.DoctorRepository;



@Service
public class DoctorService {

	@Autowired
    private DoctorRepository docRepo;

    
    public Doctor addDoctor(Doctor doctor){
       
        return docRepo.save(doctor);
    }

    

    public List<Doctor> displayAll(){

        return docRepo.findAll();
    }

   
    
}
