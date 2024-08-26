package com.prog.medicalAppointment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Medicines")
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Id;
    private String MedicineName;
    private String dosage;
    private int Quantity;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}	
	public String getMedicineName() {
		return MedicineName;
	}
	public void setMedicineName(String medicineName) {
		MedicineName = medicineName;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
}
