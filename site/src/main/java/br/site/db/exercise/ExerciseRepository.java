package br.site.db.exercise;

import java.util.List;

import br.site.model.exercise.Exercise;

public interface ExerciseRepository {
	List<Exercise> byPhonemeOfAchiquirement(Integer id);
	
	Exercise by(Integer id);
	
	List<Exercise> vowels();
	
	List<Exercise> list(Integer phonemeId, String category, Integer expertId);
	
	void save(Exercise exercise);
	
	boolean exists(String content);
	
}
