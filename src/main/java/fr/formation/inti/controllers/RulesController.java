package fr.formation.inti.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rules")

public class RulesController {

	@GetMapping(value = "/")
	public String rules(Model model) {
		return "rules";
	}

}
