<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

<form>
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
      <input type="grupo" id="grupo" name="grupo">
	  
      <input type="submit" value="Agregar">
      <input type="submit" value="Reestablecer">
</form>


</body>
</html>