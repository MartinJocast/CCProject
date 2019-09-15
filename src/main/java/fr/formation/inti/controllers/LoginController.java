package fr.formation.inti.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.inti.entities.Users;
import fr.formation.inti.services.UserService;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	UserService userService;
	
	@GetMapping(path={"/", ""})
    public String loginForm(Model model) {
        model.addAttribute("userLogin", new Users());
        return "login";
    }
	
	@PostMapping(path={"/", ""})
    public String login(@Valid Users userLogin, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userLogin", userLogin);
            return "login";
        }        
        
        Users userFind = userService.findByEmail(userLogin.getEmail());
        if (userFind.getEmail() != null && userFind.getPassword().equals(userLogin.getPassword())) {
            model.addAttribute("user", userLogin);
        	return "home";
        } else {
        	return "redirect:/";
        }
        
        
    }
}
