package fr.formation.inti.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.entities.Teams;
import fr.formation.inti.services.TeamService;

@Controller
@RequestMapping("team")
public class TeamController {

	@Autowired
	TeamService teamService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String addTeamForm(Teams team, Model model) {
		model.addAttribute("activePage", "team");
		return "myTeam";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
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
