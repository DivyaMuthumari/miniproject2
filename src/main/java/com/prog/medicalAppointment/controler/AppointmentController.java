package com.prog.medicalAppointment.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.medicalAppointment.Entity.Appointment;
import com.prog.medicalAppointment.Service.AppointmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Appointment Controller", description ="Appointment Controller")
@Controller
public class AppointmentController {

@Autowired
private AppointmentService appointmentService;

    @Operation(summary = "Display Appointments", description = "Displays the appointments")
    @GetMapping("/viewAppointment")
    public String showAllAppointment(Model model){
        List<Appointment> appointments = appointmentService.displayAll();
        model.addAttribute("appointment",appointments);

        return "displayAppointments";
    }
    
    
    @GetMapping("/addAppointment")
    public String getAddAppointmentForm(){
        return "addAppointment";
    }
    
    @Operation(summary = "Add Appointment", description = "Add Appointment")
    @PostMapping("/addAppointment")
    public String addAppointment(@ModelAttribute Appointment appointment){
        System.out.println(appointment);
    	appointmentService.addAppointment(appointment);
        return "redirect:/viewAppointment";
    }

   
    @GetMapping("/updateAppointment/{Id}")
    public String showMedicineUpdate(@PathVariable(value = "Id") int Id, Model model){
    	Appointment appointment = appointmentService.getAppointmentById(Id);
        model.addAttribute("appointment",appointment);
        return "updateAppointment";
    }
    
    @Operation(summary = "Update Appointment", description = "Update Appointment")
    @PostMapping ("/updateAppointment/{Id}")
    public String updateEmployee(@PathVariable (value = "Id") int Id,@ModelAttribute("appointment") Appointment appointment) {
    	appointmentService.updateAppointment(Id,appointment);

        return "redirect:/viewAppointment";
    }
    
    @Operation(summary = "Delete Appointment", description = "Delete Appointment")
    @GetMapping("/deleteAppointment/{Id}")
    public String deleteAppointment(@PathVariable (value = "Id") int Id, Model model) {
    	appointmentService.deleteAppointmentById(Id);        
        return "redirect:/viewAppointment";
    }

}
