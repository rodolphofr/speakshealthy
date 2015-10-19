package br.site.controller.expert;

import static br.site.model.crfa.CRFa.registry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.site.db.crfa.CRFaRepository;
import br.site.db.expert.ExpertRepository;
import br.site.model.crfa.CRFa;
import br.site.model.expert.Expert;

@Controller
@RequestMapping("expert")
public class ExpertController {
		
	@Autowired
	private ExpertRepository expertRepository;
	
	@Autowired
	private CRFaRepository crfaRepository;
	
	private static final String DIR = "expert";

	private static final String REGISTER = DIR + "/register";
	
	private static final String INDEX = DIR + "/index";
	
	private static final String GRANTED = "granted";
	
	private static final String NEW_EXPERT = "newExpert";
	
	private static final String DENIED = "denied"; 
	
	@RequestMapping(value="/index")
	public String index() {
		return INDEX;
	}

	@RequestMapping(value="/register") 
	public String register() {
		return REGISTER;
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public @ResponseBody String singin(String crfaUser, HttpSession session) {
		CRFa crfa = crfaRepository.by(registry(crfaUser));
		
		String response;
		
		if(crfa != null) {
			Expert expert = expertRepository.by(crfa);
			
			if(expert != null) {
				session.setAttribute("expert", expert);
				response = GRANTED;
			} else {
				session.setAttribute("crfa", crfa);
				response = NEW_EXPERT;
			}
			
		} else {
			response = DENIED;
		}
		
		return response;
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public @ResponseBody Expert signup(String name, HttpSession session) throws Exception {
		CRFa crfa = (CRFa) session.getAttribute("crfa");
		
		Expert expert = new Expert(crfa, name, true);
		
		expertRepository.save(expert);
		
		session.setAttribute("expert", expert);
		
		return expert;
	}
	
	
}
