package br.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.site.model.patient.Patient;
import br.site.model.patient.PatientDTO;

@Service
public class PatientService {

	@Autowired
	private PathService pathService;
	
	@Autowired
	private FileService fileService;
	
	public Patient adapt(PatientDTO dto) {
		
		if(dto.getFile() != null) {
			String photoPath = pathService.createPhotoPath(getFileName(dto));
			savePhoto(dto);
			return new Patient(dto.getName(), dto.getRg(), photoPath);
		} else {
			return new Patient(dto.getName(), dto.getRg());
		}
		
	}
	
	public void savePhoto(PatientDTO dto) {
		String absolutePath = pathService.createAbsolutePhotoPath(getFileName(dto));
		fileService.save(dto.getFile(), absolutePath);
	}
	
	private String getFileName(PatientDTO dto) {
		return fileService.createPhotoFileName(dto);
	}
	
}
