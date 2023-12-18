<%@page import="com.tracom.modelo.User"%>
<%@page import="com.tracom.modelo.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
		<div class="card">
			<div class="card-header">
				<h5>Actualizar nuevo Usuario</h5>
			</div>
			<%
				int id = Integer.parseInt((String) request.getAttribute("iduser"));
				UserDAO userDAO = new UserDAO();
				User u = userDAO.listarId(id);
			%>
			<div class="card-body">
				<form action="Controller">
				
					<label>Id</label> 
					<input 
						type="text" 
						readonly=""
						name="id"
						class="form-control"
						value="<%=u.getId() %>"
						> 
				
					<label>Nombre</label> 
					<input 
						type="text" 
						name="name"
						class="form-control"
						value="<%=u.getName() %>"
						> 
						
					<label>Apellido</label> 
					<input
						type="text" 
						name="lastname"
						class="form-control"
						value="<%=u.getLastname() %>"
						 > 
						
					<input
						type="submit" name="accion" value="Actualizar"> <a
						href="Controlador?accion=actualizar"></a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>