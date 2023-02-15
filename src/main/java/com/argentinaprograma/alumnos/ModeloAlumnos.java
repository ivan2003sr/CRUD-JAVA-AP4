package com.argentinaprograma.alumnos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//El modelo conecta con la base de datos
public class ModeloAlumnos {
	
	
	private DataSource origenDatos;
	
	//Constructor que setea origenDatos
	public ModeloAlumnos(DataSource origenDatos ) {
		
		this.origenDatos=origenDatos;
		
	}
	
	//Obtener listado de productos. Ponemos que puede dar error la conexión.
	public List<Alumnos> getAlumnos() throws Exception{
		
		//Creamos una lista donde guardaremos los alumnos
		List<Alumnos> alumnos = new ArrayList<>();
		
		Connection conexion=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		//Establecemos la conexión
		conexion=origenDatos.getConnection();
		
		
		//Creamos la consulta SQL y el creamos el Statement.
		
		String miSql="SELECT * FROM alumnos";
		statement=conexion.createStatement();
		
		//ejecutamos la consulta
		
		resultSet=statement.executeQuery(miSql);
		
		//Recorremos el resultado
		while (resultSet.next()) {
			String id=resultSet.getString("Id");
			String nombre=resultSet.getString("Nombre");
			String apellido=resultSet.getString("Apellido");
			String dni=resultSet.getString("DNI");
			String localidad=resultSet.getString("Localidad");
			String mail=resultSet.getString("mail");
			String grupo=resultSet.getString("grupo");
			
			//Vamos guardando en una variable temporal todos los datos extraidos.
			Alumnos tempAlumnos = new Alumnos(id,nombre,apellido,dni,localidad,mail,grupo);
			//Agregamos a la lista
			alumnos.add(tempAlumnos);
		}
		//retornamos la lista
		return alumnos;
	}
	
	

}
