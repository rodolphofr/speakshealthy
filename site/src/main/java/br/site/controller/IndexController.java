package br.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	private static final String INDEX = "index";
	
	@RequestMapping("index")
	public String index() {
		return INDEX;
	}
	
}