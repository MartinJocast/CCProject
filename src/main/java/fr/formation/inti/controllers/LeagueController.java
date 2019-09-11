package fr.formation.inti.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.entities.Leagues;
import fr.formation.inti.services.LeagueService;


@Controller
@RequestMapping("league")

public class LeagueController {

	@Autowired
	LeagueService leagueService;
	

	@RequestMapping(value = "/ligue", method = RequestMethod.GET)
    public String addLeagueForm(Leagues league, Model model) {
        model.addAttribute("activePage", "league");
        return "ligue";
    }
	
	
	
	
	
	@RequestMapping(value = "/ligue", method = RequestMethod.POST)
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
