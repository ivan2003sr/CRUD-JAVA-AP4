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
		
		// Leer el parámetro que llega desde el formulario
		String comando= request.getParameter("instruccion");
		
		//Si no está ese parámetro, que liste los productos.
		if(comando==null) comando="listar";
		
		//Redirigir el flujo al método listar o insertar.
		switch (comando) {
		
		case "listar":
			listarAlumnos(request, response);
			break;
		case "insertarBBDD":
			agregarAlumnos(request, response);
			break;
			
		default:
			System.out.println("Algo está mal, no debería entrar nunca acá");

		}
		
		

	}

	private void listarAlumnos(HttpServletRequest request, HttpServletResponse response) {

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
	
	private void agregarAlumnos(HttpServletRequest request, HttpServletResponse response) {
		//Leer la información que vino del formulario
		String nombre=request.getParameter("nombre");
		String apellido=request.getParameter("apellido");
		String dni=request.getParameter("dni");
		String localidad=request.getParameter("localidad");
		String email=request.getParameter("email");
		String grupo=request.getParameter("grupo");
		
		//Crear un objeto de tipo alumno
		Alumnos nuevoAlumno= new Alumnos(nombre,apellido,dni,localidad,email,grupo);
		
		//Enviar el alumno al modelo y después insertar el objeto a la BBDD
		
		modeloAlumnos.agregarAlumno(nuevoAlumno);
		
		//volver al listado
		
		listarAlumnos(request, response);
		
	}

	
	
	
	

}
