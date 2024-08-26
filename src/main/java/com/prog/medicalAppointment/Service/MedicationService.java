package com.prog.medicalAppointment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.medicalAppointment.Entity.Medicine;
import com.prog.medicalAppointment.Repository.MedicationRespository;


@Service
public class MedicationService {
	
	@Autowired
    private MedicationRespository medicineRepo;

    
    public Medicine addMedicine(Medicine medication){
       
        return medicineRepo.save(medication);
    }

    

    public List<Medicine> displayAll(){

        return medicineRepo.findAll();
    }

   
    public Medicine getMedicineById(int Id) {
        Optional<Medicine> medicineId = medicineRepo.findById(Id);
        if(medicineId.isPresent()){
            return medicineId.get();
        }else{
            throw new RuntimeException("Medicine not found-id: " + Id);
        }

    }

    public void updateMedicine(int Id, Medicine medication) {
        Optional<Medicine> existingMedicine = medicineRepo.findById(Id);
        if (existingMedicine.isPresent()) {            
        	existingMedicine.get().setMedicineName(medication.getMedicineName());
        	existingMedicine.get().setDosage(medication.getDosage());
        	existingMedicine.get().setQuantity(medication.getQuantity());

        	medicineRepo.save(existingMedicine.get());
        }

    }

    
    public void deleteMedicineById(int Id){

    	medicineRepo.deleteById(Id);        
    }

}
