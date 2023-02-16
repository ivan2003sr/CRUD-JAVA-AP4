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
		try {
		//Redirigir el flujo al método listar o insertar.
		switch (comando) {
		
		case "listar":
			listarAlumnos(request, response);
			break;
		case "insertarBBDD":
			agregarAlumnos(request, response);
			break;
			
		case "update":
			rescatarAlumno(request, response);
			break;
			
		case "actualizarBBDD":
			actualizaAlumno(request,response);
			break;
			
		case "delete":
			eliminarAlumno(request,response);
			break;
			
		default:
			System.out.println("Algo esta mal, no debe entrar nunca aca");

		}
		
		}catch (Exception e){
			e.printStackTrace();
		}

	}







	private void listarAlumnos(HttpServletRequest request, HttpServletResponse response) throws Exception{

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
	
	private void agregarAlumnos(HttpServletRequest request, HttpServletResponse response) throws Exception{
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
	
	private void rescatarAlumno(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Leer el ID que viene del listado
		String idAlumno = request.getParameter("IdAlumno");
		
		//Enviar el ID al modelo, Comunicar con el modelo para que haga una consulta a la BBDD con el ID
		Alumnos alumno= modeloAlumnos.getAlumno(idAlumno);
		
		// Rescatar los atributos
		request.setAttribute("IdActualizar", alumno);
		
		//Enviar los atributos al formulario actualizar
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/actualizarAlumno.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	private void actualizaAlumno(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Leer los datos que vienen del formulario de actualizar
		String id=request.getParameter("IdAlumno");
		String nombre=request.getParameter("nombre");
		String apellido=request.getParameter("apellido");
		String dni=request.getParameter("dni");
		String localidad=request.getParameter("localidad");
		String email=request.getParameter("email");
		String grupo=request.getParameter("grupo");
		
		//Crear un alumno con esta info
		Alumnos alumnoActualizado= new Alumnos(id,nombre,apellido,dni,localidad,email,grupo);

		//Actulizar la BBDD
		
		modeloAlumnos.actualizaBBDD(alumnoActualizado);
		
		//Volver al listado
		listarAlumnos(request, response);
		
	}
	
	private void eliminarAlumno(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Capturar el ID
		
		String id=request.getParameter("IdAlumno");
		//Borrar de la BBDD
		modeloAlumnos.eliminarAlumno(id);
		
		//Volver a la lista
		listarAlumnos(request, response);
		
	}
	
	
	
	

	
	
	
	

}
