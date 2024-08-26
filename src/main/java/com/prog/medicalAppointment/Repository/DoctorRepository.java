package com.prog.medicalAppointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.medicalAppointment.Entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
