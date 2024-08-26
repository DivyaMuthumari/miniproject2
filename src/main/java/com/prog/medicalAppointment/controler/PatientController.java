package com.prog.medicalAppointment.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.prog.medicalAppointment.Entity.Patient;
import com.prog.medicalAppointment.Service.PatientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Patient Controller", description ="Patient Controller")
@Controller
public class PatientController {
	@Autowired
    private PatientService patientService;
	
	@Operation(summary = "Display Patients", description = "Display Patients")
    @GetMapping("/viewPatient")
    public String showAllPatients(Model model){
        List<Patient> patients = patientService.displayAll();
        model.addAttribute("patient",patients);

        return "displayPatient";
    }
    
    @GetMapping("/addPatient")
    public String getAddPatientForm(){
        return "addPatient";
    }
    
    @Operation(summary = "Add Patients", description = "Add Patients")
    @PostMapping("/addPatient")
    public String addPatient(@ModelAttribute Patient patient){

    	patientService.addPatient(patient);
        return "redirect:/viewPatient";
    }

    
    @GetMapping("/updatePatient/{Id}")
    public String showPatientUpdate(@PathVariable(value = "Id") int Id, Model model){
    	Patient patient = patientService.getPatientById(Id);
        model.addAttribute("patient",patient);
        return "updatePatient";
    }
    
    @Operation(summary = "Update Patient", description = "Update Patient")
    @PostMapping ("/updatePatient/{Id}")
    public String updatePatient(@PathVariable (value = "Id") int Id,@ModelAttribute("patient") Patient patient) {
    	patientService.updatePatient(Id,patient);

        return "redirect:/viewPatient";
    }
    
    @Operation(summary = "Delete Patient", description = "Delete Patient")
    @GetMapping("/deletePatient/{Id}")
    public String deletePatient(@PathVariable (value = "Id") int Id,Model model) {
    	patientService.deletePatientById(Id);        
        return "redirect:/viewPatient";
    }

}
