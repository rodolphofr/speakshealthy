package br.site.controller.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.site.db.phoneme.PhonemeRepository;
import br.site.model.phoneme.Phoneme;

@Controller
@RequestMapping("training")
public class TrainingController {

	private static final String DIR = "training";
	
	private static final String INDEX = DIR + "/index";
	
	private static final String WORDS_PAGE = DIR + "/word/index";

	private static final String SENTENCES_PAGE = DIR + "/sentence/index";
	
	@Autowired
	private PhonemeRepository phonemeRepository;
	
	@RequestMapping(value="/index")
	public String index() {
		return INDEX;
	}
	
	@RequestMapping(value="/words")
	public String wordsPage(ModelMap model) {
		this.phonemes(model);
		return WORDS_PAGE;
	}
	
	@RequestMapping(value="/sentences")
	public String sentencesPage(ModelMap model) {
		this.phonemes(model);
		return SENTENCES_PAGE;
	}
	
	private void phonemes(ModelMap model) {
		List<Phoneme> phonemes = phonemeRepository.listConsonant();
		List<Phoneme> archiphonemes = phonemeRepository.listArchiphoneme();
		model.addAttribute("phonemes", phonemes).addAttribute("archiphonemes", archiphonemes);
	}
	
	
}
