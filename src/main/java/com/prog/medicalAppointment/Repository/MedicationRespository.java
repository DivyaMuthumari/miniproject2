package com.prog.medicalAppointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.medicalAppointment.Entity.Medicine;



public interface MedicationRespository extends JpaRepository<Medicine, Integer> {

}
