package com.argentinaprograma.alumnos;

public class Alumnos {
	
	//creo una variable por cada columna de la tabla alumnos
	private String id;
	private String nombre;
	private String apellido;
	private String dni;
	private String direccion;
	private String mail;
	private String telefono;
	
	//Un constructor con todos los campos
	public Alumnos(String id, String nombre, String apellido, String dni, String direccion, String mail,
			String telefono) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.direccion = direccion;
		this.mail = mail;
		this.telefono = telefono;
	}
	
	//Otro constructor sin el campo id

	public Alumnos(String nombre, String apellido, String dni, String direccion, String mail, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.direccion = direccion;
		this.mail = mail;
		this.telefono = telefono;
	}
	
	//Genero todos los getters and setters.

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	//Sobreescribimos el método toString
	@Override
	public String toString() {
		return "Alumnos [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", direccion="
				+ direccion + ", mail=" + mail + ", telefono=" + telefono + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
