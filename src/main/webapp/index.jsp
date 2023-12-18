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
				<a href="Controller?accion=agregar" class="btn btn-primary">Nuevo Usuario</a>
			</div>
			<div class="card-body">
				<table class="table table-hover">
					<thead>

						<tr>
							<th>ID</th>
							<th>Nombres</th>
							<th>Apellidos</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<%
	UserDAO userDAO = new UserDAO();
	List<User> datos = userDAO.list();
	for (User u : datos) {
	%>
						<tr>
							<td><%=u.getId() %></td>
							<td><%=u.getName() %></td>
							<td><%=u.getLastname() %></td>
							<td>
								<a href="Controller?accion=editar&id=<%=u.getId()%>" class="btn btn-warning">Edit</a>
								<a href="Controller?accion=eliminar&id=<%=u.getId()%>" class="btn btn-danger">Delete</a>
							</td>
						</tr>
						<%
	}
	%>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>