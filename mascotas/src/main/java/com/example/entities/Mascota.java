package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_mascota;

	@Column
	private String nombre;
	
	@Column
	private int edad;
	private String descripcion;

	public Mascota(String nombre, int edad, String descripcion) {

		this.nombre = nombre;
		this.edad = edad;
		this.descripcion = descripcion;
	}

	public Mascota() {
	}

	public int getId_mascota() {
		return id_mascota;
	}

	public void setId_mascota(int id_mascota) {
		this.id_mascota = id_mascota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Mascota [id_mascota=" + id_mascota + ", nombre=" + nombre + ", edad=" + edad + ", descripcion="
				+ descripcion + "]";
	}
	
	
	
	
	

}
