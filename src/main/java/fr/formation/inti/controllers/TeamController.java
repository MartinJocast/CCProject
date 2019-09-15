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
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.entities.Teams;
import fr.formation.inti.entities.Users;
import fr.formation.inti.services.TeamService;
import fr.formation.inti.services.UserService;

@Controller
@RequestMapping("team")
public class TeamController {

	@Autowired
	TeamService teamService;
	@Autowired
	UserService userService;

	@GetMapping(path = {"","/"})
	public String addTeamForm(Teams team, Model model, Principal principal) {
		User loggedUser = (User) ((Authentication) principal).getPrincipal();
		Users loggedInUser = userService.findByEmail(loggedUser.getUsername());
		model.addAttribute("loggedInUser", loggedInUser);
		model.addAttribute("team", team);
		return "myTeam";
	}

	@PostMapping(path = {"","/"})
	public String addTeam(@Valid Teams team, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("activePage", "team");
			return "myTeam";
		}

		if (teamService.findByName(team.getName()) != null) {
			return "createTeam";
		}

		teamService.save(team);
		return "myTeam";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateTeams(Teams team) {
		return "redirect:/team/view/" + team.getIdTeams();
	}

}
