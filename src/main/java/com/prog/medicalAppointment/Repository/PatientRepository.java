package com.prog.medicalAppointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.medicalAppointment.Entity.Patient;

public interface PatientRepository extends JpaRepository <Patient, Integer>{

}
