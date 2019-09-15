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

import fr.formation.inti.entities.Players;
import fr.formation.inti.entities.Users;
import fr.formation.inti.services.PlayerService;
import fr.formation.inti.services.UserService;

@Controller
@RequestMapping("player")
public class PlayerController {

	@Autowired
	PlayerService playerService;
	@Autowired
	UserService userService;
	
//	    @GetMapping(path = { "", "/", "/home" })
//	    public String index(Model model) {
//	        model.addAttribute("activePage", "home");
//	        return "index";
//	    }
        
	@GetMapping(path = {"","/"})
	public String SelectPlayerForm(Players player, Model model, Principal principal) {
		User loggedUser = (User) ((Authentication) principal).getPrincipal();
		Users loggedInUser = userService.findByEmail(loggedUser.getUsername());
		model.addAttribute("loggedInUser", loggedInUser);
		model.addAttribute("player", player);
		return "myTeam";
	}

	@PostMapping(path = {"","/"})
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
