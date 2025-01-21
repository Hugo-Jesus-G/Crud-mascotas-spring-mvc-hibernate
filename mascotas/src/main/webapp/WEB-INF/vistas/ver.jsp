<%@page import="com.example.entities.Mascota"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Mascotas</title>
</head>
<body>
	<h1>Lista de Mascotas</h1>



	<table border="1">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Descripción</th>
				<th>Edad</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>


			<%
			// Obtener la lista de mascotas del modelo
			//get attribute obtiene un objeto generico por lo tanto sale el warning de que no asegura de que es de tipo List<Mascota> en el casteo

			//si el valor que se le pasa al get attribute asegura una list<macotas> con esta anotacion se quita el warining

			@SuppressWarnings("unchecked")

			List<Mascota> mascotas = (List<Mascota>) request.getAttribute("mascotas");

			if (mascotas != null) {
				for (Mascota m : mascotas) {
			%>

			<tr>
				<td><%=m.getNombre()%></td>
				<td><%=m.getDescripcion()%></td>
				<td><%=m.getEdad()%></td>
				<td><a href="editarMascota/<%=m.getId_mascota()%>">Editar</a></td>
				<td><a href="eliminar/<%=m.getId_mascota()%>">Eliminar</a></td>

			</tr>


			<%
			}
			} else {
			%>
			<tr>
				<td colspan="3">No hay mascotas disponibles.</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<br />
	<a href="form">Volver al formulario</a>
</body>
</html>
