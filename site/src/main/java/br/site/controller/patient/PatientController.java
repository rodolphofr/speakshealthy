package br.site.controller.patient;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.site.db.expert.ExpertRepository;
import br.site.db.patient.PatientRepository;
import br.site.model.expert.Expert;
import br.site.model.patient.Patient;
import br.site.model.patient.PatientDTO;
import br.site.service.PatientService;

@Controller
@RequestMapping("patient")
public class PatientController {
	
	private static final String DIR = "patient";
	
	private static final String REGISTER = DIR + "/register";
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ExpertRepository expertRepository;
	
	@Autowired
	private PatientService service;
	
	@RequestMapping(value="/register")
	public String register() {
		return REGISTER;
	}
	
	@Transactional
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public @ResponseBody Patient save(HttpSession session, String name, String rg, MultipartFile file) throws Exception {
		PatientDTO dto = new PatientDTO(name, rg, file);
		Patient patient = service.adapt(dto);
 
		if(patient != null) {
			patientRepository.save(patient);
			
			Expert expert = (Expert) session.getAttribute("expert");
			expert.addPatient(patient);
			expertRepository.update(expert);
		}
		
		return patient;
	}
	
	@RequestMapping(value="/search")
	public @ResponseBody List<Patient> search(HttpSession session, @RequestParam("term") String term) {
		Expert expert = (Expert) session.getAttribute("expert");
		List<Patient> results = patientRepository.search(term, expert);
		return results;
	}
	
	@RequestMapping(value="/{id}")
	public String get(@PathVariable("id") Integer id, HttpSession session) {
		Patient patient = patientRepository.byId(id);
		session.setAttribute("patient", patient);
		return "redirect:/expert/index";
	}
	
}
