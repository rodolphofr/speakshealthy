package br.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.site.model.recordingHistory.RecordingHistory;
import br.site.model.recordingHistory.RecordingHistoryDTO;

@Service
public class RecordingHistoryService {

	@Autowired
	private PathService pathService;
	
	@Autowired
	private FileService fileService;
	
	public RecordingHistory adapt(RecordingHistoryDTO dto) {
		String record = pathService.createAudioPath(getFileName(dto));
		saveAudio(dto);
		return new RecordingHistory(record, dto.getPatient(), dto.getExercise());
	}
	
	public void saveAudio(RecordingHistoryDTO dto) {
		String absolutePath = pathService.createAbsoluteAudioPath(getFileName(dto));
		fileService.save(dto.getFile(), absolutePath);
	}
	
	private String getFileName(RecordingHistoryDTO dto) {
		return fileService.createAudioFileName(dto);
	}
	
}
