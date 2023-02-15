package com.argentinaprograma.alumnos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletPruebas
 */
@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Establecer el DataSource del pool de conexiones
	
		@Resource(name="jdbc/YoProgramo")
		private DataSource dataSource;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Crear un objeto print Writter que imprimirá los resultados en el navegador
		
		PrintWriter salida  = response.getWriter();
		
		//Decie que el tipo de impresión será texto plano
		response.setContentType("text/plain");
		
		//Crear objetos para la conexión con Base de datos
		
		Connection conexion=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		//Intentar conectar con la base de datos
		
		try {
			// toma la conexión del pool-Request
			conexion=dataSource.getConnection();
			//Sentencia SQL
			String miSql="SELECT * FROM alumnos";
			
			//Seteo un objeto consulta SQL
			statement=conexion.createStatement();
			
			//Ejecuto la consulta que establecí en la sentencia
			resultSet=statement.executeQuery(miSql);
			
			//bucle que imprime mientras halla apellidos 
			while(resultSet.next()) {
				String apellidos=resultSet.getString(2);
				salida.println(apellidos);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
