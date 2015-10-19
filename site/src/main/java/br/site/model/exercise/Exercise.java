package br.site.model.exercise;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.site.model.phoneme.Phoneme;

@Entity
@Table(name="exercise")
public class Exercise {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String demo;
	
	@Column
	private String content;
	
	@Column
	@Enumerated(value = EnumType.STRING)
	private Exercise.Type type;

	@Column
	@Enumerated(value = EnumType.STRING)
	private Exercise.Category category;
	
	@ManyToOne
	@JoinColumn(name="phoneme_id")
	private Phoneme phoneme;
	
	@Transient
	private boolean done;
	
	public Exercise() {
	}
	
	public Exercise(String demo, String content, Type type, Category category, Phoneme phoneme) {
		this.demo = demo;
		this.content = content;
		this.type = type;
		this.category = category;
		this.phoneme = phoneme;
	}
	
	public Exercise(String content, Type type, Category category, Phoneme phoneme) {
		this.content = content;
		this.type = type;
		this.category = category;
		this.phoneme = phoneme;
	}
	
	public Exercise(Integer id, String demo, String content, boolean done) {
		this.id = id;
		this.demo = demo;
		this.content = content;
		this.done = done;
	}

	public Integer getId() {
		return id;
	}

	public String getDemo() {
		return demo;
	}

	public String getContent() {
		return content.toUpperCase();
	}


	public Exercise.Type getType() {
		return type;
	}


	public Phoneme getPhoneme() {
		return phoneme;
	}

	public Exercise.Category getCategory() {
		return category;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public void done() {
		this.done = true;
	}
	
	public enum Type {
		AUDIO, VIDEO, DOC;
	}
	
	public enum Category {
		SENTENCE, WORD, ACQUIREMENT;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercise other = (Exercise) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		return true;
	}

	public static Comparator<Exercise> ExerciseComparator = new Comparator<Exercise>() {
		@Override
		public int compare(Exercise exercise, Exercise otherExercise) {
			return exercise.getContent().compareTo(otherExercise.getContent());
		}
	};
}
