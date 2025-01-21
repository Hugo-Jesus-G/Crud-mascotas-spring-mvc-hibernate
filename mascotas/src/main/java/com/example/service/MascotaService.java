package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CrudDAO;
import com.example.entities.Mascota;

@Service
public class MascotaService {
	@Autowired
	private CrudDAO<Mascota> mascotaDaoImp;

	/*
	 * private CrudDAO<Mascota> mascotaDaoI; este setter se inyectaba desde el
	 * dispatcher public void setMascotaDaoI(CrudDAO<Mascota> mascotaDaoI) {
	 * this.mascotaDaoI = mascotaDaoI; }
	 * 
	 */

	public void guardar(Mascota mascota) {
		mascotaDaoImp.guardar(mascota);
	}

	public Mascota encontrarPorId(int id) {
		return mascotaDaoImp.encontrarPorId(id);
	}

	public List<Mascota> mostrarTodos() {
		return mascotaDaoImp.mostrarTodos();
	}

	public void actualizar(Mascota mascota) {
		mascotaDaoImp.actualizar(mascota);
	}

	public void eliminar(Mascota mascota) {
		mascotaDaoImp.eliminar(mascota);
	}
}
