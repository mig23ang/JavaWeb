package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		
		//no cambia la url mantiene, se usa para rutas propias de spring
		return "forwards:/app/index";
		
		//redirije la pagina y cambia la url
		//return "redirect:/app/index";
	}
}
