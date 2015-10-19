package br.site.db.patient;

import java.io.Serializable;
import java.util.List;

import br.site.model.expert.Expert;
import br.site.model.patient.Patient;

public interface PatientRepository {
	Serializable save(Patient patient);
	Patient byId(Integer id); 
	List<Patient> search(String search, Expert expert);
}
