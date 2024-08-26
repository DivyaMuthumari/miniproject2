package com.prog.medicalAppointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.medicalAppointment.Entity.Appointment;

public interface AppointmentRespository extends JpaRepository<Appointment, Integer> {

}
