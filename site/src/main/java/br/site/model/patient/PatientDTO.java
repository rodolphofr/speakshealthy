package br.site.model.patient;

import org.springframework.web.multipart.MultipartFile;

public class PatientDTO {
	
	private String name;
	
	private String rg;
	
	private MultipartFile file;
	
	public PatientDTO() {
	}
	
	public PatientDTO(String name, String rg, MultipartFile file) {
		this.name = name;
		this.rg = rg;
		this.file = file;
	}

	public MultipartFile getFile() {
		return file;
	}
	
	public String getName() {
		return name;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
}
