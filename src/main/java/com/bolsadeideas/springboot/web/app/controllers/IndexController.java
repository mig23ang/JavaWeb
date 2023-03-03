package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	// un controlador siempre tienes metodos, como consultas a la base de datos,
	// crear, listar etc...
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	// @RequestMapping(value = "/index", method =RequestMethod.GET) esto es igual a:
	// @GetMapping(value = "/index")igual a:
	@GetMapping({ "/index", "/", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();

		usuario.setNombre("miguel");
		usuario.setApellido("Reyes");
		// usuario.setEmail("miguel.reyes@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {

		model.addAttribute("titulo", textoListar);

		return "listar";
	}

	// este atributo sirve para poblar todos los metodos del controlador, se usas si
	// la data se quiere usar en varias vistas de resto no se usa
	@ModelAttribute("usuarios")
	public List<Usuario> poblaUsuarios() {

		List<Usuario> usuarios = Arrays.asList(new Usuario("andres", "alvarez", "andres@gmail.com"),
				new Usuario("carlos", "carlas", "carlos.com"), new Usuario("juuan", "juanes", "juan@gmail.com"));

		return usuarios;
	}

}
