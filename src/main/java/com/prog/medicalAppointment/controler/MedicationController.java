package com.prog.medicalAppointment.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.medicalAppointment.Entity.Medicine;
import com.prog.medicalAppointment.Service.MedicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Medication Controller", description ="Medication Controller")
@Controller
public class MedicationController {
	
	@Autowired
    private MedicationService medicineService;

	@Operation(summary = "Display Medicines", description = "Display Medicines")
    @GetMapping("/viewMedicine")
    public String showAllMedicine(Model model){
        List<Medicine> medicines = medicineService.displayAll();
        model.addAttribute("medicine",medicines);

        return "displayMedicines";
    }
    
    @GetMapping("/addMedicine")
    public String getAddMedicineForm(){
        return "addMedicine";
    }
    
    @Operation(summary = "Add Medicines", description = "Add Medicines")
    @PostMapping("/addMedicine")
    public String addMedicine(@ModelAttribute Medicine medication){

    	medicineService.addMedicine(medication);
        return "redirect:/viewMedicine";
    }

    
    @GetMapping("/updateMedicine/{Id}")
    public String showMedicineUpdate(@PathVariable(value = "Id") int Id, Model model){
    	Medicine medicine = medicineService.getMedicineById(Id);
        model.addAttribute("medicine",medicine);
        return "updateMedicine";
    }
    
    @Operation(summary = "Update Medicine", description = "Update Medicine")
    @PostMapping ("/updateMedicine/{Id}")
    public String updateMedicine(@PathVariable (value = "Id") int Id,@ModelAttribute("medicine") Medicine medication) {
    	medicineService.updateMedicine(Id,medication);

        return "redirect:/viewMedicine";
    }
    
    @Operation(summary = "Delete Medicine", description = "Delete Medicine")
    @GetMapping("/deleteMedicine/{Id}")
    public String deleteMedicine(@PathVariable (value = "Id") int Id,Model model) {
        medicineService.deleteMedicineById(Id);        
        return "redirect:/viewMedicine";
    }

	
}
