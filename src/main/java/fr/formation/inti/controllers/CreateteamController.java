package fr.formation.inti.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.entities.TeamsHavePlayers;



@Controller
@RequestMapping("createteam")
public class CreateteamController {

	

	@RequestMapping(value = "/createteam", method = RequestMethod.GET)
    public String addCreateTeamForm (Model model) {
        model.addAttribute("activePage", "createteam");
        return "createTeam";
    }
	
	
	
	
	
	@RequestMapping(value = "/createteam", method = RequestMethod.POST)
    public String addCreateTeam(@Valid TeamsHavePlayers teamshaveplayers, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("activePage", "createteam");
            return "createTeam";
        }
		return null;

 
	
	
}
}
