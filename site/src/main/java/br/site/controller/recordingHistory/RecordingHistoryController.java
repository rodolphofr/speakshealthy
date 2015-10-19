package br.site.controller.recordingHistory;

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
import br.site.db.recordingHistory.RecordingHistoryRepository;
import br.site.model.patient.Patient;
import br.site.model.recordingHistory.RecordingHistory;
import br.site.model.recordingHistory.RecordingHistoryDTO;
import br.site.service.RecordingHistoryService;

@Controller
@RequestMapping("record")
public class RecordingHistoryController {
	
	@Autowired
	private RecordingHistoryRepository recordingHistoryRepository;
	
	@Autowired
	private ExerciseRepository exerciseRepository;

	@Autowired
	private RecordingHistoryService service;

	
	@RequestMapping(value="/save/audio", method=RequestMethod.POST)
	public @ResponseBody RecordingHistory save(HttpSession session, MultipartFile file, Integer id) {
		RecordingHistoryDTO dto = new RecordingHistoryDTO((Patient) session.getAttribute("patient"),
															exerciseRepository.by(id), 
															file); 
		RecordingHistory recordingHistory = service.adapt(dto);
		recordingHistoryRepository.save(recordingHistory);
		return recordingHistory;
	}
	
	@RequestMapping(value="/list/{id}")
	public @ResponseBody List<RecordingHistory> list(HttpSession session, @PathVariable("id") Integer exerciseId) {
		Patient patient = (Patient) session.getAttribute("patient");
		return recordingHistoryRepository.recordingsBy(patient, exerciseId);
	}
	
}
