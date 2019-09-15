package fr.formation.inti.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.inti.entities.Users;
import fr.formation.inti.services.UserService;


@Controller
@RequestMapping("compte")
public class CompteController {

	@Autowired
	UserService userService;
	
	@GetMapping(path = {"","/"})
	public String CompteForm(Model model, Principal principal, Users userUpdate) {
		model.addAttribute("userUpdate", userUpdate);
		User loggedUser = (User) ((Authentication) principal).getPrincipal();
		Users loggedInUser = userService.findByEmail(loggedUser.getUsername());
		model.addAttribute("loggedInUser", loggedInUser);
		return "compte";
	}
	
	@PostMapping(path = {"","/"})
    public String Compte(@Valid Users userUpdate, BindingResult bindingResult, Model model, Principal principal) {
		if (bindingResult.hasErrors()) {
            model.addAttribute("userUpdate", userUpdate);
            return "redirect:compte";
        }        		
		User loggedUser = (User) ((Authentication) principal).getPrincipal();
		Users loggedInUser = userService.findByEmail(loggedUser.getUsername());
		loggedInUser.setPassword(hashPassword(userUpdate.getPassword()));
		loggedInUser.setPseudo(userUpdate.getPseudo());
		loggedInUser.setEmail(userUpdate.getEmail());
        userService.save(loggedInUser);
        return "redirect:home";
	}
		
	private String hashPassword(String password) {
		String crypt = BCrypt.gensalt(5);
		String passwordCrypt = BCrypt.hashpw(password, crypt);
		return passwordCrypt;
	}
	
}