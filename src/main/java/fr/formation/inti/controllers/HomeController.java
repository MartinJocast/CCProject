package fr.formation.inti.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.inti.entities.Users;
import fr.formation.inti.services.UserService;



@Controller
@RequestMapping("home")

public class HomeController {
	
	@Autowired
	UserService userService;

	@GetMapping(path = {"","/"})
	public String HomeForm(Model model, Principal principal) {
	
	User loggedUser = (User) ((Authentication) principal).getPrincipal();
	Users loggedInUser = userService.findByEmail(loggedUser.getUsername());
	model.addAttribute("loggedInUser", loggedInUser);
	return "home";
	
}


	@PostMapping(path = {"","/"})
    public String Home(@Valid Users home, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("activePage", "home");
            return "home";
        }
		return null;
	}
}