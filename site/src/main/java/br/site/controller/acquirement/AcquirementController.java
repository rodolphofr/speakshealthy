package br.site.controller.acquirement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.site.db.exercise.ExerciseRepository;
import br.site.db.phoneme.PhonemeRepository;
import br.site.model.phoneme.Phoneme;

@Controller
@RequestMapping("acquirement")
public class AcquirementController {
	
	private static final String DIR = "acquirement";
	
	private static final String INDEX = DIR + "/index";
	
	private static final String VOWEL_EXERCISE_PAGE = DIR + "/vowel/index";
	
	private static final String CONSONANT_EXERCISE_PAGE = DIR + "/consonant/index";
	
	private static final String ACHIPHONEME_EXERCISE_PAGE = DIR + "/archiphoneme/index";
	
	@Autowired
	private PhonemeRepository phonemeRepository;

	@Autowired
	private ExerciseRepository exerciseRepository;
	
	@RequestMapping("/index")
	public String index(ModelMap model) {
		List<Phoneme> consonants = phonemeRepository.listConsonant();
		List<Phoneme> archiphonemes = phonemeRepository.listArchiphoneme();
		
		model.addAttribute("phonemes", consonants)
			 .addAttribute("archiphonemes", archiphonemes);
		
		return INDEX;
	}
	
	@RequestMapping("/vowel")
	public String vowelPage(ModelMap model) {
		model.addAttribute("vowels", exerciseRepository.vowels());
		return VOWEL_EXERCISE_PAGE;
	}
	
	@RequestMapping("/consonant/{id}")
	public String consonantPage(ModelMap model, @PathVariable Integer id) {
		model.addAttribute("consonants", exerciseRepository.byPhonemeOfAchiquirement(id))
			 .addAttribute("phoneme", phonemeRepository.by(id));
		return CONSONANT_EXERCISE_PAGE;
	}
	
	@RequestMapping("/archiphoneme/{id}")
	public String nasalPage(ModelMap model, @PathVariable Integer id) {
		model.addAttribute("archiphonemes", exerciseRepository.byPhonemeOfAchiquirement(id))
			 .addAttribute("archiphoneme", phonemeRepository.by(id));
		return ACHIPHONEME_EXERCISE_PAGE;
	}
	
}
