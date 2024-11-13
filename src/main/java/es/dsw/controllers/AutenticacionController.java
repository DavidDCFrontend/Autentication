package es.dsw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.dsw.models.User;

@Controller
@SessionAttributes("user")
public class AutenticacionController {

	@PostMapping("/autentication")
	public String autentication(@RequestParam String name,
								@RequestParam String password,
								Model model) {
		
		if(!name.equals("pedro")) {
			return "redirect:/index?error=1";
		} 
		
		if(!password.equals("1234")) {
			User user = (User) model.getAttribute("user");
			user.setUsername(name);
			return "redirect:/index?error=2";
		}
		
		model.addAttribute("user", new User(name, password));
		
		return "redirect:/home";
	}
}
