package br.site.service;

import static br.site.util.StringUtil.addUnderline;
import static br.site.util.StringUtil.isEmpty;
import static br.site.util.StringUtil.removeBlankSpace;
import static br.site.util.StringUtil.removeSpecialCharacters;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.site.model.exercise.ExerciseDTO;
import br.site.model.patient.PatientDTO;
import br.site.model.recordingHistory.RecordingHistoryDTO;
import br.site.util.DateUtil;

@Service
public class FileService {

	private static final String AUDIO_EXTENSION = ".wav";
	
	private static final String VIDEO_EXTENSION = ".mp4";
	
	private static final String PHOTO_EXTENSION = ".jpg";
	
	public void save(MultipartFile multipartFile, String path) {
		try {
			File file = new File(path);
			multipartFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}

	public String createAudioFileName(RecordingHistoryDTO dto) {
		String fileName = dto.getPatient().getId()
						+ dto.getExercise().getId()
						+ DateUtil.format(new Date()) 
						+ AUDIO_EXTENSION;
		
		return fileName.toLowerCase();
	}
	
	public String createAudioFileName(ExerciseDTO dto) {
		String fileName = addUnderline(dto.getWord()) + AUDIO_EXTENSION;
		return fileName.toLowerCase();
	}

	public String createVideoFileName(String fileName) {
		return (fileName + VIDEO_EXTENSION).toLowerCase();
	}
	
	public String createPhotoFileName(PatientDTO dto) {
		String fileName = removeBlankSpace(dto.getName()).toLowerCase();
		if(!isEmpty(dto.getRg())) {
			fileName += removeSpecialCharacters(dto.getRg()) + PHOTO_EXTENSION;
		} else {
			fileName += PHOTO_EXTENSION; 
		}
		return fileName.toLowerCase();
	}
}
