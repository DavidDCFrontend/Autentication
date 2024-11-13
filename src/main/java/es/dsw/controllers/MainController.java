package es.dsw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import es.dsw.models.User;

@Controller
@SessionAttributes("user")
public class MainController {

	@GetMapping({"/", "/index"})
	public String getIndex(@RequestParam(name="error", defaultValue= "0")String codError, 
			               Model model) {
		
		if(!model.containsAttribute("user")) {
			model.addAttribute("user", new User());
		}
		
		if(model.containsAttribute("user")) {
			User user = (User) model.getAttribute("user");
			model.addAttribute("user", user);
		}
		
		String messageError = "";
		
		if("1".equals(codError)) {
			model.addAttribute("messageError", "El nombre de usuario es incorrecto.");
			
		} else if("2".equals(codError)) {
			model.addAttribute("messageError", "La contraseña es incorrecta.");
			
		} else if("100".equals(codError)) {
			model.addAttribute("messageError", "Sesión finalizada");
		} 
		
		
		return "index";
	}
	
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/seccion1")
	public String getSeccion1(Model model) {
		
		User user = (User) model.getAttribute("user");
		
		if(user.getUsername() == null && user.getUserpassword() == null) {
			return "redirect:/index";
		}
		
		return "views/seccion1";
	}
	
	@GetMapping("/seccion2")
	public String getSeccion2() {
		return "views/seccion2";
	}
	
	@GetMapping("/seccion3")
	public String getSeccion3() {
		return "views/seccion3";
	}
	
	@GetMapping("/seccion4")
	public String getSeccion4() {
		return "views/seccion4";
	}
	
	@GetMapping("/cerrar")
	public String signOut(SessionStatus session) {
		
		session.setComplete();
		
		return "redirect:/index?error=100";
	}
}