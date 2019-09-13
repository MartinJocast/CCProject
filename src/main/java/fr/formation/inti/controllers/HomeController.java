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
@RequestMapping("home")

public class HomeController {

	@GetMapping(path = "/")
	public String HomeForm(Model model) {
		        model.addAttribute("activePage", "home");
		        return "home";
	
}


	@PostMapping(path = "/")
    public String Home(@Valid Users home, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("activePage", "home");
            return "home";
        }
		return null;
	}
}