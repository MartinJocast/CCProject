package fr.formation.inti.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.inti.entities.Users;


@Controller
@RequestMapping("compte")
public class CompteController {

	
	@GetMapping(path = "/")
	public String CompteForm(Model model) {
		        model.addAttribute("activePage", "compte");
		        return "compte";
	
	}
	
	@PostMapping(path = "/")
    public String Compte(@Valid Users compte, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("activePage", "compte");
            return "compte";
        }
		return null; 
	
	
	
}
}