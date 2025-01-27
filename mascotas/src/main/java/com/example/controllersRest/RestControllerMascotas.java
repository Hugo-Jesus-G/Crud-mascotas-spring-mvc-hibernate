package com.example.controllersRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.example.entities.Mascota;
import com.example.service.MascotaService;

@RestController
@RequestMapping("/rest")
public class RestControllerMascotas {

	@Autowired
	@Qualifier("mascotaService")
	private MascotaService service;

	@GetMapping("/todos")
	public ResponseEntity<List<Mascota>> obtenerMascotas() {
		List<Mascota> mascotas = service.mostrarTodos();

		if (mascotas.isEmpty()) {
//buil no retonar nada
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		}

		return ResponseEntity.ok(mascotas);
	}

	@PostMapping("/crear")

	public ResponseEntity<Void> crearMascota(@RequestBody Mascota mascota) {

		if (mascota == null) {
			return ResponseEntity.notFound().build();
		}
		service.guardar(mascota);

		return ResponseEntity.ok().build();

	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int id_mascota) {

		Mascota mascota = service.encontrarPorId(id_mascota);
		if (mascota == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		service.eliminar(mascota);

		return ResponseEntity.ok().build();

	}

	@GetMapping("/buscar/{id}")

	// request body recibe el obejto completo,si soloo necesatia un valor s¿como el
	// id solo se pone el numero en el json

	// public ResponseEntity<Mascota> bucarMascota(@RequestBody int mascota) {
	public ResponseEntity<Mascota> bucarMascota(@PathVariable("id") int idMascota) {

		Mascota mascota = service.encontrarPorId(idMascota);

		if (mascota == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(mascota);

	}

	@PutMapping("/actualizar")
	public ResponseEntity<Void> actualizar(@RequestBody Mascota mascota) {

		if (mascota == null) {
			return ResponseEntity.notFound().build();
		}

		service.actualizar(mascota);
		return ResponseEntity.ok().build();

	}

}
