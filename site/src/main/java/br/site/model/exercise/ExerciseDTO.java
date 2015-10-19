package br.site.model.exercise;

import org.springframework.web.multipart.MultipartFile;

import br.site.model.phoneme.Phoneme;

public class ExerciseDTO {

	private String word;
	
	private MultipartFile file;
	
	private Phoneme phoneme;
	
	private String category;

	private String type;
	
	public ExerciseDTO(String word, MultipartFile file, Phoneme phoneme, String category, String type) {
		this.word = word;
		this.file = file;
		this.phoneme = phoneme;
		this.category = category;
		this.type = type;
	}

	public ExerciseDTO(String word, Phoneme phoneme, String category, String type) {
		this.word = word;
		this.phoneme = phoneme;
		this.category = category;
		this.type = type;
	}


	public String getWord() {
		return word.toUpperCase();
	}

	public MultipartFile getFile() {
		return file;
	}


	public Phoneme getPhoneme() {
		return phoneme;
	}

	public Exercise.Category getCategory() {
		switch (this.category.toUpperCase()) {
		case "WORD":
			return Exercise.Category.WORD;
		case "SENTENCE":
			return Exercise.Category.SENTENCE;
		case "ACQUIREMENT":
			return Exercise.Category.ACQUIREMENT;
		default:
			return null;
		}
	}
	
	public Exercise.Type getType() {
		switch (this.type) {
		case "AUDIO":
			return Exercise.Type.AUDIO;
		case "VIDEO":
			return Exercise.Type.VIDEO;
		case "DOC":
			return Exercise.Type.DOC;
		default:
			return null;
		}
	}
	
}
