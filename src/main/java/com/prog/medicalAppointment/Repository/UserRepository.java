package com.prog.medicalAppointment.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.medicalAppointment.Entity.User;

public interface UserRepository extends JpaRepository <User, Integer> {
}