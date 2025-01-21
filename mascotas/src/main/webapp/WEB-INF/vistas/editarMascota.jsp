<%@page import="com.example.entities.Mascota"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar</title>
</head>
<body>

<h1>Editar Mascota</h1>
<form action="/mascotas/guardarCambios" method="post">
	<%
	Mascota m = (Mascota) request.getAttribute("mascota");
	%>


	<label for="id" >Id</label>
	<input type="text" value="<%=m.getId_mascota()%>" name="id_mascota" readonly="readonly">
	<br> Nombre
	<input type="text" name="nombre" value="<%=m.getNombre()%>">
	<br> Edad
	<input type="text" name="edad" value="<%=m.getEdad()%>">

	<br> Descripcion
	<textarea id="descripcion" name="descripcion" rows="4" cols="50"
		><%=m.getDescripcion()%></textarea>

	<br>
	<br>
<input type="submit" value="Guardar Cambios">
</form>
<a href="/mascotas/verMascotas">Regresar</a>


</body>
</html>