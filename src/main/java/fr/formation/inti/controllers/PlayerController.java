package fr.formation.inti.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.entities.Players;
import fr.formation.inti.services.PlayerService;

@Controller
@RequestMapping("player")
public class PlayerController {

	@Autowired
	PlayerService playerService;
	
	
	    @GetMapping(path = { "", "/", "/home" })
	    public String index(Model model) {
	        model.addAttribute("activePage", "home");
	        return "index";
	    }
        

	@RequestMapping(value = "/selectplayer", method = RequestMethod.GET)
	public String SelectPlayerForm(Players player, Model model) {
		model.addAttribute("activePage", "player");
		return "myTeam";
	}

	@RequestMapping(value = "/selectplayer", method = RequestMethod.POST)
    public String SelectPlayer(@Valid Players player, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("activePage", "player");
            return "myTeam";
        }
        
        if(playerService.findById(player.getIdPlayer()) !=null) {
        	return"myTeam";
        }
        
       
   	 playerService.save(player);
     return "myTeam";
	 
}

	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePlayers(Players player) {
		return "redirect:/player/view/" + player.getIdPlayer();
	}

}
