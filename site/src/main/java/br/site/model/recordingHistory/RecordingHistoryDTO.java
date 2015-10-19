package br.site.model.recordingHistory;

import org.springframework.web.multipart.MultipartFile;

import br.site.model.exercise.Exercise;
import br.site.model.patient.Patient;

public class RecordingHistoryDTO {
	
	private Patient patient;

	private Exercise exercise;

	private MultipartFile file;
	
	public RecordingHistoryDTO(Patient patient, Exercise exercise, MultipartFile file) {
		this.patient = patient;
		this.exercise = exercise;
		this.file = file;
	}
	
	public Exercise getExercise() {
		return exercise;
	}
	
	public MultipartFile getFile() {
		return file;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	
}
