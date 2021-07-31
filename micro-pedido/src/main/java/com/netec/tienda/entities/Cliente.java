package com.netec.tienda.entities;


public class Cliente {
	private int id;
	private String nombre;
	private int edad;
	private String email;
	private String ciudadOrigen;
	private int port;
	
	
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	public final String getNombre() {
		return nombre;
	}
	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public final int getEdad() {
		return edad;
	}
	public final void setEdad(int edad) {
		this.edad = edad;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getCiudadOrigen() {
		return ciudadOrigen;
	}
	public final void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	
	

}
