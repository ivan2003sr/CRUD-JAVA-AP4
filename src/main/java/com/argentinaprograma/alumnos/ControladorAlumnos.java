package com.argentinaprograma.alumnos;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorAlumnos
 */
@WebServlet("/ControladorAlumnos")
public class ControladorAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModeloAlumnos modeloAlumnos;
	
	//Establecer el DataSource del pool de conexiones
	@Resource(name="jdbc/YoProgramo")
	private DataSource dataSource;
	
	//Construimos el método init, equivalente al main de una clase java común.
	@Override
public void init() throws ServletException {
	
	super.init();
	try {
	
	modeloAlumnos=new ModeloAlumnos(dataSource);
	
	}catch (Exception e) {
		throw new ServletException();
	}
}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorAlumnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creamos la lista
		List<Alumnos> alumnos;
		
		//vamos a llamar a getAlumnos, como le dijimos que lanza una exception, estamos obligados
		//a ponerlo dentro de un try-catch
		try {
			
			//Obtenemos la lista de alumnos del modelo 
			alumnos = modeloAlumnos.getAlumnos();
		
		
		//Agregamos la lista al request
			
			request.setAttribute("ListaAlumnos", alumnos);
		
		
		//Enviamos el request a la vista
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListaAlumnos.jsp");
			requestDispatcher.forward(request, response);
			
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
