package com.jpa.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabitacion;
	
	private int numero;
    private String descripcion;
    private Double precio;
    private String estado;
    
    private Long idAdministrador;
    private Long idCategoria;
	public Long getIdHabitacion() {
		return idHabitacion;
	}
	public void setIdHabitacion(Long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getIdAdministrador() {
		return idAdministrador;
	}
	public void setIdAdministrador(Long idAdministrador) {
		this.idAdministrador = idAdministrador;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

}
