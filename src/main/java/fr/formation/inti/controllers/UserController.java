package fr.formation.inti.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.entities.Users;
import fr.formation.inti.services.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
    public String addUserForm(Model model) {
        model.addAttribute("user", new Users());
        return "inscription";
    }
	
	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
    public String addUser(@Valid Users user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "inscription";
        }        
        if (userService.findByEmail(user.getEmail()) != null) {
        	return "inscription"; 
        }
        user.setRole("user");
        user.setSecurityRequest("null");
        userService.save(user);
        model.addAttribute("user", user);
        return "home";
    }
	
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String updateEmployee(Users user) {
//        userService.update(user);
//        return "redirect:/home";
//    }
}
