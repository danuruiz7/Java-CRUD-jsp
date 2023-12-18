<%@page import="com.tracom.modelo.User"%>
<%@page import="java.util.List"%>
<%@page import="com.tracom.modelo.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<div class="container mt-4">
		<div class="card">
			<div class="card-header">
				<h5>Agregar nuevo Usuario</h5>
			</div>
			<div class="card-body">
				<form action="Controller">
					<label>Nombre</label> 
					<input type="text" name="name"
						class="form-control"> 
						
					<label>Apellido</label> 
					<input
						type="text" name="lastname" class="form-control"> 
						
					<input
						type="submit" name="accion" value="Guardar"> <a
						href="Controlador?accion=index"></a>
				</form>
			</div>
		</div>
	</div>

</body>
</html>