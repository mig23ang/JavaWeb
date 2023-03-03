package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/")
	public String index(
			@RequestParam(name = "texto", required = false, defaultValue = "el valor enviadoe s incorrecto") String texto,
			Model model) {
		model.addAttribute("resultado", "el texto enviado es:" + texto);
		return "params/index";
	}

	// enviar parametros atravez de la URL
	@GetMapping("/string")
	public String param(
			@RequestParam(name = "texto", required = false, defaultValue = "el valor enviadoe s incorrecto") String texto,
			Model model) {
		model.addAttribute("resultado", "el texto enviado es:" + texto);
		return "params/ver";
	}

	// enviar varios parametros atravez de la URL
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "el texto enviado es:'" + saludo + "'y el numero es '" + numero + "'");
		return "params/ver";
	}

	// enviar varios parametros atravez de la URL enviando objeto hhtpservletRequest
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			numero = 0;
		}

		model.addAttribute("resultado", "el texto enviado es:'" + saludo + "'y el numero es '" + numero + "'");
		return "params/ver";
	}
}
