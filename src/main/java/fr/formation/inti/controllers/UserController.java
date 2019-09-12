package fr.formation.inti.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.inti.entities.Users;
import fr.formation.inti.services.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping(value = "/inscription")
    public String addUserForm(Model model) {
        model.addAttribute("user", new Users());
        return "inscription";
    }
	
	@PostMapping(value = "/inscription")
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
        user.setPassword(hashPassword(user.getPassword()));
        userService.save(user);
        model.addAttribute("user", user);
        return "home";
    }

	private String hashPassword(String password) {
		String crypt = BCrypt.gensalt(5);
		String passwordCrypt = BCrypt.hashpw(password, crypt);
		return passwordCrypt;
	}
	
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String updateEmployee(Users user) {
//        userService.update(user);
//        return "redirect:/home";
//    }
}
