<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Importamos la tag-lib jstl. Se usa para no mezclar código java con código html-->
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!--  Decoración bootstrap -->

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0
.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min
.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/p
opper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.
min.js"></script>

<!-- Creamos decoración CSS -->
<style type="text/css">
.titulos{

font-weight:bold;
background-color:yellow;
}
table, th, td{
border: 1px solid;

}

td{
background-color:#f4f4f4;
}
</style>
</head>


<body>

<table>

<!-- Títulos de la tabla -->
<tr>
<td class="titulos">Id</td>
<td class="titulos">Nombre</td>
<td class="titulos">Apellido</td>
<td class="titulos">DNI</td>
<td class="titulos">Localidad</td>
<td class="titulos">e-mail</td>
<td class="titulos">Grupo</td>
<td class="titulos">Actualizar datos</td>

</tr>

<!-- Bucle for usando jstl -->

<c:forEach var="tempAlumnos" items="${ListaAlumnos}">

<!-- Link para cada alumno con su id -->

<c:url var="linkTemp" value="ControladorAlumnos">
<c:param name="instruccion" value="update"></c:param>
<c:param name="IdAlumno" value="${tempAlumnos.id}"></c:param>


</c:url>

<tr>
<td>${tempAlumnos.id}</td>
<td>${tempAlumnos.nombre}</td>
<td>${tempAlumnos.apellido}</td>
<td>${tempAlumnos.dni}</td>
<td>${tempAlumnos.localidad}</td>
<td>${tempAlumnos.mail}</td>
<td>${tempAlumnos.grupo}</td>
<td><a href="${linkTemp}">Actualiza</a></td>
</tr>

</c:forEach>

</table>

<!--  agrego boton para insertar  -->
<br>
<div id="boton">
<button type="button" class="btn btn-primary" onclick="window.location.href='insertarAlumno.jsp'">Agregar Alumno</button>
</div>


</body>
</html>