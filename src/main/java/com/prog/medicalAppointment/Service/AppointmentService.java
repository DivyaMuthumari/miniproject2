package com.prog.medicalAppointment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.medicalAppointment.Entity.Appointment;
import com.prog.medicalAppointment.Repository.AppointmentRespository;

@Service
public class AppointmentService {

	@Autowired
    private AppointmentRespository appointmentRepo;

    
    public Appointment addAppointment(Appointment appointment){
       
        return appointmentRepo.save(appointment);
    }

    

    public List<Appointment> displayAll(){

        return appointmentRepo.findAll();
    }

   
    public Appointment getAppointmentById(int Id) {
        Optional<Appointment> appointmentId = appointmentRepo.findById(Id);
        if(appointmentId.isPresent()){
            return appointmentId.get();
        }else{
            throw new RuntimeException("Appointment not found-id: " + Id);
        }

    }

    public void updateAppointment(int Id, Appointment appointment) {
        Optional<Appointment> existingAppointment = appointmentRepo.findById(Id);
        if (existingAppointment.isPresent()) {            
        	existingAppointment.get().setDoctorId(appointment.getDoctorId());
        	existingAppointment.get().setDoctorName(appointment.getDoctorName());
        	existingAppointment.get().setPatientId(appointment.getPatientId());
        	existingAppointment.get().setPatientName(appointment.getPatientName());
        	existingAppointment.get().setAppointmentDate(appointment.getAppointmentDate());
        	existingAppointment.get().setVisitReason(appointment.getVisitReason());

        	appointmentRepo.save(existingAppointment.get());
        }

    }

    
    public void deleteAppointmentById(int Id){

    	appointmentRepo.deleteById(Id);        
    }
}
