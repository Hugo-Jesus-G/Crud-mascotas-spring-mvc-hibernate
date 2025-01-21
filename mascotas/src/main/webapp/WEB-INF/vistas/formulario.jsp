<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Mascota</title>
</head>
<body>
    <h1>Formulario para Agregar Mascota</h1>
 <form action="guardarMascota" method="post">
    <input type="text" name="nombre" placeholder="Nombre" required><br/>
    <input type="text" name="descripcion" placeholder="Descripción" required><br/>
    <input type="number" name="edad" placeholder="Edad" required><br/>
    <button type="submit">Guardar</button>
    
    <br>
    <br>
    
    <a href="verMascotas">Ver mascotas</a>
</form>

</body>
</html>
