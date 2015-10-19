package br.site.util;

import br.site.model.exercise.Exercise;
import br.site.model.exercise.Exercise.Category;

public class CategoryUtil {

	public static Category getCategory(String category) {
		
		switch(category.toUpperCase()) {
			case "ACQUIREMENT":
				return Exercise.Category.ACQUIREMENT;

			case "WORD":
				return Exercise.Category.WORD;
				
			case "SENTENCE":
				return Exercise.Category.SENTENCE;
		}
		
		return null;
		
	}
}
