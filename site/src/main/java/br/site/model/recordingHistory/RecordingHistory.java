package br.site.model.recordingHistory;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.site.model.exercise.Exercise;
import br.site.model.patient.Patient;

@Entity
@Table(name="recording_history")
public class RecordingHistory {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String record;
	
	@Column
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;
	
	@OneToOne
	@JoinColumn(name="exercise_id")
	private Exercise exercise;
	
	public RecordingHistory() {
	}

	public RecordingHistory(String record, Patient patient, Exercise exercise) {
		this.record = record;
		this.patient = patient;
		this.exercise = exercise;
		this.date = new Date();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRecord() {
		return record;
	}
	
	public void setRecord(String record) {
		this.record = record;
	}
	
	public Exercise getExercise() {
		return exercise;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
}
