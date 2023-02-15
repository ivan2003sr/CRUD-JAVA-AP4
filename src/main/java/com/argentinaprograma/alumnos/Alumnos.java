package com.argentinaprograma.alumnos;

public class Alumnos {
	
	//creo una variable por cada columna de la tabla alumnos
	private String id;
	private String nombre;
	private String apellido;
	private String dni;
	private String localidad;
	private String mail;
	private String grupo;
	
	//Un constructor con todos los campos
	public Alumnos(String id, String nombre, String apellido, String dni, String localidad, String mail,
			String grupo) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.localidad = localidad;
		this.mail = mail;
		this.grupo = grupo;
	}
	
	//Otro constructor sin el campo id

	public Alumnos(String nombre, String apellido, String dni, String localidad, String mail, String grupo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.localidad = localidad;
		this.mail = mail;
		this.grupo = grupo;
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

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	//Sobreescribimos el método toString
	@Override
	public String toString() {
		return "Alumnos [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", localidad="
				+ localidad + ", mail=" + mail + ", grupo=" + grupo + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
