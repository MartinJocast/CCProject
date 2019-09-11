package fr.formation.inti.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RulesController {

	@GetMapping(value = "/rules")
	public String rules(Model model) {
		return "rules";
	}

}
