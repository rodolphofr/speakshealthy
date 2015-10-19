package br.site.controller.exercise;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.site.db.exercise.ExerciseRepository;
import br.site.db.expert.ExpertRepository;
import br.site.db.phoneme.PhonemeRepository;
import br.site.db.recordingHistory.RecordingHistoryRepository;
import br.site.model.exercise.Exercise;
import br.site.model.exercise.ExerciseDTO;
import br.site.model.expert.Expert;
import br.site.model.patient.Patient;
import br.site.model.recordingHistory.RecordingHistory;
import br.site.service.ExerciseService;

@Controller
@RequestMapping("exercise")
public class ExerciseController {
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	@Autowired
	private PhonemeRepository phonemeRepository;

	@Autowired
	private ExpertRepository expertRepository;
	
	@Autowired
	private ExerciseService service;
	
	@Autowired
	private RecordingHistoryRepository recordingHistoryRepository;
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public @ResponseBody Exercise save(HttpSession session, 
			String content, 
			MultipartFile file, 
			Integer phonemeId, 
			String category, 
			String type) throws Exception {
		
		ExerciseDTO dto = new ExerciseDTO(content, file, phonemeRepository.by(phonemeId), category, type);
		Exercise exercise = service.adapt(dto);
		
		if(exercise != null) {
			Expert expert = (Expert) session.getAttribute("expert");
			if(expert != null) {
				expert.addExercise(exercise);
				expertRepository.update(expert);
			} else {
				exerciseRepository.save(exercise);
			}
		}
		
		return exercise;
		
	}

	@RequestMapping("/{id}")
	public @ResponseBody Exercise get(@PathVariable("id") Integer id) {
		return exerciseRepository.by(id);
	}
	
	@RequestMapping(value="/list")
	public @ResponseBody List<Exercise> list(HttpSession session, Integer id, String category) {
		Expert expert = (Expert) session.getAttribute("expert");
		
		List<Exercise> exercises = exerciseRepository.list(id, category, expert.getId());
		
		Patient patient = (Patient) session.getAttribute("patient");
		
		if(patient != null && exercises != null && !exercises.isEmpty()) {
			List<RecordingHistory> results = recordingHistoryRepository.byExercises(exercises);
			if(results != null) {
				exercises = service.adapt(exercises, results);
			}
		}
		
		Collections.sort(exercises, Exercise.ExerciseComparator);
		
		return exercises;
	}
	
	@RequestMapping(value="/exists")
	public @ResponseBody boolean exists(HttpSession session, String content) {
		if(exerciseRepository.exists(content)) 
			return true;
		return false;
	}
}
