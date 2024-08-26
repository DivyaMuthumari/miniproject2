package com.prog.medicalAppointment.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.medicalAppointment.Entity.Doctor;
import com.prog.medicalAppointment.Service.DoctorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Doctor Controller", description ="Doctor Controller")
@Controller
public class DoctorController {

	@Autowired
    private DoctorService docService;

	@Operation(summary = "Show All Doctors", description = "Show All Doctors")
    @GetMapping("/viewDoctors")
    public String showAllDoctors(Model model){
        List<Doctor> doctors = docService.displayAll();
        model.addAttribute("doctor",doctors);

        return "Doctors";
    }
    
    @GetMapping("/addDoctor")
    public String getAddDoctorForm(){
        return "addDoctor";
    }
    
    @Operation(summary = "Add Doctor", description = "Add Doctor")
    @PostMapping("/addDoctor")
    public String addDoctor(@ModelAttribute Doctor doc){

    	docService.addDoctor(doc);
        return "redirect:/viewDoctors";
    }

       
	
}
