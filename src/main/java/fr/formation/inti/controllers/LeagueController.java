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

import fr.formation.inti.entities.Leagues;
import fr.formation.inti.entities.Users;
import fr.formation.inti.services.LeagueService;
import fr.formation.inti.services.UserService;


@Controller
@RequestMapping("league")

public class LeagueController {

	@Autowired
	LeagueService leagueService;
	@Autowired
	UserService userService;
	
	@GetMapping(path = {"","/"})
    public String addLeagueForm(Leagues league, Model model, Principal principal) {
		User loggedUser = (User) ((Authentication) principal).getPrincipal();
		Users loggedInUser = userService.findByEmail(loggedUser.getUsername());
		model.addAttribute("loggedInUser", loggedInUser);
        model.addAttribute("league", league);
        return "ligue";
    }

	
	@PostMapping(path = {"","/"})
    public String addLeague(@Valid Leagues league, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("activePage", "league");
            return "ligue";
        }
        
        if(leagueService.findByName(league.getName()) !=null) {
        	return"ligue";
        }
	

	
	 leagueService.save(league);
      return "home";
      
	 
}
	
           
}
