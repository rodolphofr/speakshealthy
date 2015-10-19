package br.site.model.expert;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.site.model.crfa.CRFa;
import br.site.model.exercise.Exercise;
import br.site.model.patient.Patient;

@Entity
@Table(name="expert")
public class Expert {

		@Id	
		@GeneratedValue
		private Integer id;
		
		@OneToOne
		@JoinColumn(name="crfa_id")
		private CRFa crfa;
		
		@Column(name="name")
		private String name;
		
		@Column
		private boolean activated;
		
		@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
		@JoinTable(name = "expert_patient", joinColumns = @JoinColumn(name = "expert_id"), 	inverseJoinColumns = @JoinColumn(name = "patient_id"), 
					uniqueConstraints = @UniqueConstraint(name = "uni_expert_patient", columnNames = { "expert_id", "patient_id" }))
		private Set<Patient> patients = new HashSet<Patient>();

		@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
		@JoinTable(name = "expert_exercise", joinColumns = @JoinColumn(name = "expert_id"), 	inverseJoinColumns = @JoinColumn(name = "exercise_id"), 
		uniqueConstraints = @UniqueConstraint(name = "uni_expert_exercise", columnNames = { "expert_id", "exercise_id" }))
		private Set<Exercise> exercises = new HashSet<Exercise>();
		
		public Expert() {
		}
		
		public Expert(CRFa crfa, String name, boolean activated) {
			this.crfa = crfa;
			this.name = name;
			this.activated = activated;
		}

		public Integer getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public Set<Patient> getPatients() {
			return patients;
		}
		
		public Set<Exercise> getExercises() {
			return exercises;
		}
		
		public void addPatient(Patient patient) {
			getPatients().add(patient);
		}
		
		public void addExercise(Exercise exercise) {
			getExercises().add(exercise);
		}
		
		public boolean isActivated() { 
			return activated;
		}

		public CRFa getCrfa() {
			return crfa;
		}
}
