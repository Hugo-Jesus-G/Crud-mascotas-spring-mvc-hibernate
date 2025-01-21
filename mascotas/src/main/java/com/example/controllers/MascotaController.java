package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entities.Mascota;
import com.example.service.MascotaService;

@Controller
public class MascotaController {

	@Autowired
	@Qualifier("mascotaService")
	private MascotaService service;

	@RequestMapping
	public String index() {
		return "index";
	}

	@RequestMapping("/form")
	public String mostrarFormPrincipal() {
		return "formulario";
	}

	@PostMapping("/guardarMascota")
	public String guardarMascota(@ModelAttribute Mascota mascota) {

		if (mascota != null) {

			service.guardar(mascota);

			return "redirect:/verMascotas";
		}
		return "formulario";

	}

	@GetMapping("/verMascotas")
	public String verMascotas(Model model) {

		List<Mascota> listaMascotas = service.mostrarTodos();

		model.addAttribute("mascotas", listaMascotas);

		return "ver";
	}

	// formato http://localhost:8080/mascotas/mascotas/editarMascota/1
	@GetMapping("/editarMascota/{id}")
	public String editarConPathVariable(@PathVariable("id") int id, Model model) {
		Mascota mascota = service.encontrarPorId(id);

		if (mascota != null) {

			model.addAttribute("mascota", mascota);
			return "editarMascota";

		}
		return "redirect:/verMascotas";
	}

	// formato http://localhost:8080/mascotas/mascotas/editarMascota?id=1
	@GetMapping("/editarMascota")
	public String editarConRequestParam(@RequestParam("id") int id, Model model) {
		
		
		Mascota mascota = service.encontrarPorId(id);
		model.addAttribute("mascota", mascota);
		return "editarMascota";
	}

	@PostMapping("/guardarCambios")
	public String cambiosConfirmados(@ModelAttribute Mascota mascota) {
		if (mascota != null) {

			service.actualizar(mascota);
			return "redirect:/verMascotas";

		}

		return "ver";

	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id) {

		Mascota mascota = service.encontrarPorId(id);
		service.eliminar(mascota);
		return "redirect:/verMascotas";

	}

}
