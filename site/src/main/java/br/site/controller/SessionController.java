package br.site.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.site.model.expert.Expert;
import br.site.model.patient.Patient;

@Controller
@RequestMapping("session")
public class SessionController {

	private static String REDIRECT_TO_EXPERT_INDEX = "redirect:/expert/index";

	private static String REDIRECT_TO_INDEX = "redirect:/index";
	
	@RequestMapping(value="/hasSession")
	public @ResponseBody boolean hasSession(HttpSession session) {
		Patient patient = (Patient) session.getAttribute("patient");
		if(patient != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping(value="/patient/finalize")
	public String logoutPatient(HttpSession session) {
		if((Patient) session.getAttribute("patient") != null) {
			session.invalidate();
			return REDIRECT_TO_EXPERT_INDEX; 
		} 
		return null;
	}
	
	@RequestMapping(value="/expert/finalize")
	public String logoutExpert(HttpSession session) {
		Expert expert = (Expert) session.getAttribute("expert");
		if(expert != null) {
			session.invalidate();
		}
		return REDIRECT_TO_INDEX;
	}
}
