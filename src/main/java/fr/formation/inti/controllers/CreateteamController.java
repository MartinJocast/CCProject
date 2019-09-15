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

import fr.formation.inti.entities.TeamsHavePlayers;
import fr.formation.inti.entities.Users;
import fr.formation.inti.services.UserService;



@Controller
@RequestMapping("createteam")
public class CreateteamController {

	@Autowired
	UserService userService;
	
	@GetMapping(path = {"","/"})
    public String addCreateTeamForm (Model model, Principal principal) {
		User loggedUser = (User) ((Authentication) principal).getPrincipal();
		Users loggedInUser = userService.findByEmail(loggedUser.getUsername());
		model.addAttribute("loggedInUser", loggedInUser);
        return "createTeam";
    }

	@PostMapping(path = {"","/"})
    public String addCreateTeam(@Valid TeamsHavePlayers teamshaveplayers, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("activePage", "createteam");
            return "createTeam";
        }
		return null;
	}
	
}
