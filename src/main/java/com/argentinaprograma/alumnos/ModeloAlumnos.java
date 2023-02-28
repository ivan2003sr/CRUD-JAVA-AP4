package com.argentinaprograma.alumnos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//El modelo conecta con la base de datos
public class ModeloAlumnos {
	
	
	private DataSource origenDatos;
	private Connection connection=null;
	private Statement statement=null;
	private ResultSet resultSet=null;
	private PreparedStatement preparedStatement=null;
	private Alumnos alumnos = null;
	
	//Constructor que setea origenDatos
	public ModeloAlumnos(DataSource origenDatos ) {
		
		this.origenDatos=origenDatos;
		
	}
	
	//Obtener listado de productos. Ponemos que puede dar error la conexi�n.
	public List<Alumnos> getAlumnos() throws Exception{
		
		//Creamos una lista donde guardaremos los alumnos
		List<Alumnos> alumnosList = new ArrayList<>();
		

		
		//Establecemos la conexi�n
		connection=origenDatos.getConnection();
		
		
		//Creamos la consulta SQL y el creamos el Statement.
		
		String miSql="SELECT * FROM alumnos";
		statement=connection.createStatement();
		
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
			alumnos = new Alumnos(id,nombre,apellido,dni,localidad,mail,grupo);
			//Agregamos a la lista
			alumnosList.add(alumnos);
		}
		
		statement.close();
		connection.close();
		//retornamos la lista
		return alumnosList;
	}
	public void agregarAlumno(Alumnos nuevoAlumno) throws Exception {
		// Obtener la conexión con la base de datos
		
		
		try {
			connection=origenDatos.getConnection();
			
			//Crear la instrucción SQL
			
			String sql = "INSERT INTO alumnos (Nombre, Apellido, DNI, Localidad, mail, grupo)"
					+ "VALUES(?,?,?,?,?,?)";
			
			preparedStatement=connection.prepareStatement(sql);
			
			//Rescatar los parámetros para el alumno
			
			preparedStatement.setString(1, nuevoAlumno.getNombre());
			preparedStatement.setString(2, nuevoAlumno.getApellido());
			preparedStatement.setString(3, nuevoAlumno.getDni());
			preparedStatement.setString(4, nuevoAlumno.getLocalidad());
			preparedStatement.setString(5, nuevoAlumno.getMail());
			preparedStatement.setString(6, nuevoAlumno.getGrupo());
			//Ejecutar la instrucicón SQL insertando al alumno
			
			preparedStatement.execute();
			
		}catch (Exception e) {
			
		}finally {
			preparedStatement.close();
			connection.close();
		}
		
		
		
	}

	public Alumnos getAlumno(String idAlumno) throws SQLException {
		
		try {
		//Conectar a la BBFDD
			connection=origenDatos.getConnection();
		//Generar SQL que busque el alumno
		String sql = "SELECT * FROM alumnos WHERE Id=?";
		
		//Crear la consulta preparada
		
		preparedStatement=connection.prepareStatement(sql);
		
		//Establecer parámetros
		preparedStatement.setString(1, idAlumno);
		//Ejecutar la consulta
		
		resultSet=preparedStatement.executeQuery();
		
		//Obtener los datos de respuesta
		
		if(resultSet.next()) {
			
			String id=resultSet.getString("Id");
			String nombre=resultSet.getString("Nombre");
			String apellido=resultSet.getString("Apellido");
			String dni=resultSet.getString("DNI");
			String localidad=resultSet.getString("Localidad");
			String mail=resultSet.getString("mail");
			String grupo=resultSet.getString("grupo");
			
			//Guardamos los datos
			
			alumnos = new Alumnos(id,nombre,apellido,dni,localidad,mail,grupo);
			
			
		} else {
			throw new Exception("No se encuentra ese alumno con codigo = " + idAlumno);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			preparedStatement.close();
		}
	
		return alumnos;
	}

	public void actualizaBBDD(Alumnos alumnoActualizado) throws Exception {
		
		
		
		
		//Conecto:
		connection=origenDatos.getConnection();
		
		//Creo la sentencia SQL
		
		String sql = "UPDATE alumnos SET Nombre=?, Apellido=?, DNi=?, Localidad=?, mail=?, grupo=? WHERE Id=?";
		
		preparedStatement=connection.prepareStatement(sql);
		
		//Paso los parámetros
		
		preparedStatement.setString(1,alumnoActualizado.getNombre());
		preparedStatement.setString(2,alumnoActualizado.getApellido());
		preparedStatement.setString(3,alumnoActualizado.getDni());
		preparedStatement.setString(4,alumnoActualizado.getLocalidad());
		preparedStatement.setString(5,alumnoActualizado.getMail());
		preparedStatement.setString(6,alumnoActualizado.getGrupo());
		preparedStatement.setString(7,alumnoActualizado.getId());
		
		//Ejecuto
		preparedStatement.execute();
		
		preparedStatement.close();
		connection.close();
	}

	public void eliminarAlumno(String id) throws Exception{
		
		
		//Conecto:
		connection=origenDatos.getConnection();
		
		
		//Creo SQL
		String sql="DELETE FROM alumnos WHERE Id=?";
		
		//Preparo consulta
	preparedStatement=connection.prepareStatement(sql);
		
		//Establezco par�metros
		
		preparedStatement.setString(1,id);
		//Ejecuto
	preparedStatement.execute();
	
	preparedStatement.close();
	connection.close();
		
	}
	
	

}