<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- Importamos la tag-lib jstl. Se usa para no mezclar c�digo java con c�digo html-->
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- Creamos decoraci�n CSS -->
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

<!-- T�tulos de la tabla -->
<tr>
<td class="titulos">Id</td>
<td class="titulos">Nombre</td>
<td class="titulos">Apellido</td>
<td class="titulos">DNI</td>
<td class="titulos">Direcci�n</td>
<td class="titulos">e-mail</td>
<td class="titulos">Tel�fono</td>

</tr>

<!-- Bucle for usando jstl -->

<c:forEach var="tempAlumnos" items="${ListaAlumnos}">

<tr>
<td>${tempAlumnos.id}</td>
<td>${tempAlumnos.nombre}</td>
<td>${tempAlumnos.apellido}</td>
<td>${tempAlumnos.dni}</td>
<td>${tempAlumnos.direccion}</td>
<td>${tempAlumnos.mail}</td>
<td>${tempAlumnos.telefono}</td>
</tr>

</c:forEach>

</table>





</body>
</html>