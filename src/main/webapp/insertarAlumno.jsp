<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


<style>
      form {
        text-align: left;
      }

      label, input {
        display: block;
        margin: 2px;

      }
      input{
      background-color: #ffff7d }
    </style>

</head>
<body>

<!-- con método get viaja hacia el controlador -->
<form name="form1" method="get" action="ControladorAlumnos">
<input type="hidden" name="instruccion" value="insertarBBDD">
      <label for="nombre">Nombre:</label>
      <input type="text" id="nombre" name="nombre">
	  
      <label for="apellido">Apellido:</label>
      <input type="text" id="apellido" name="apellido">
	  
      <label for="dni">DNI:</label>
      <input type="text" id="dni" name="dni">
	  
      <label for="direccion">Localidad:</label>
      <input type="text" id="localidad" name="localidad">
	  
      <label for="email">Email:</label>
      <input type="email" id="email" name="email">
	  
      <label for="telefono">Grupo:</label>
      <input type="text" id="grupo" name="grupo">
	  
      <input type="submit" value="Agregar">
      <input type="submit" value="Reestablecer">
</form>


</body>
</html>