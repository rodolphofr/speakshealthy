package br.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.site.model.exercise.Exercise;
import br.site.model.exercise.ExerciseDTO;
import br.site.model.recordingHistory.RecordingHistory;

@Service
public class ExerciseService {

	@Autowired
	private PathService pathService;
	
	@Autowired
	private FileService fileService;
	
	public Exercise adapt(ExerciseDTO dto) {
		
		if(dto.getFile() != null) {
			String demo = pathService.createAudioDemoPath(getFileName(dto));
			saveMedia(dto);
			return new Exercise(demo, dto.getWord(), dto.getType(), dto.getCategory(), dto.getPhoneme());
		} else {
			return new Exercise(dto.getWord(), dto.getType(), dto.getCategory(), dto.getPhoneme());
		}
		
	}
	
	public void saveMedia(ExerciseDTO dto) {
		switch (dto.getType()) {
		case AUDIO:
			String path = pathService.createAbsoluteAudioDemoPath(getFileName(dto));
			fileService.save(dto.getFile(), path);
			break;
			
		case VIDEO:
			break;

		default:
			
		}
	}
	
	private String getFileName(ExerciseDTO dto) {
		return fileService.createAudioFileName(dto);
	}
	
	public List<Exercise> adapt(List<Exercise> exercises, List<RecordingHistory> recordings) {
		for(Exercise exercise : exercises) {
			for(RecordingHistory record : recordings) {
				if(record.getExercise().getId() == exercise.getId()) {
					exercise.done();
				}
			}
		}
		return exercises;
	}
	
}
