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
	  
      <label for="direccion">Dirección:</label>
      <input type="text" id="direccion" name="direccion">
	  
      <label for="email">Email:</label>
      <input type="email" id="email" name="email">
	  
      <label for="telefono">Teléfono:</label>
      <input type="tel" id="telefono" name="telefono">
	  
      <input type="submit" value="Agregar">
      <input type="submit" value="Reestablecer">
</form>


</body>
</html>