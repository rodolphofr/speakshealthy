package br.site.db.phoneme;

import java.io.Serializable;
import java.util.List;

import br.site.model.phoneme.Phoneme;

public interface PhonemeRepository {
	
	List<Phoneme> listVowel();
	List<Phoneme> listConsonant();
	List<Phoneme> listArchiphoneme();
	Serializable save(Phoneme phoneme);
	Phoneme by(Integer id);
}
