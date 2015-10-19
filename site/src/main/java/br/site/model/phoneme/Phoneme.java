package br.site.model.phoneme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phoneme")
public class Phoneme {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	@Enumerated(value = EnumType.STRING)
	private Phoneme.Classification classification;
	
	public Phoneme() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Phoneme.Classification getClassification() {
		return classification;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setClassification(Phoneme.Classification classification) {
		this.classification = classification;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public enum Classification {
		VOWEL, CONSONANT, ARCHIPHONEME;
	}		
}
