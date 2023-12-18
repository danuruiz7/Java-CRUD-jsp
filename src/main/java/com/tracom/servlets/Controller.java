package com.tracom.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracom.modelo.UserDAO;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String add="agregar.jsp";
	String edit="edit.jsp";
	String index="index.jsp";
	String acceso="";
   
    public Controller() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		if(accion.equals("agregar")) {
			acceso=add;
		}
		
		else if (accion.equals("Guardar")) {
			String nombre = request.getParameter("name");
			String apellido = request.getParameter("lastname");
			
			UserDAO userDAO = new UserDAO();
			userDAO.add(nombre, apellido);
			acceso=index;
		}
		
		else if (accion.equals("editar")) {
			request.setAttribute("iduser", request.getParameter("id"));
			acceso=edit;
		}
		
		else if (accion.equals("Actualizar")) {
			String nombres = request.getParameter("name");
			String apellidos = request.getParameter("lastname");
			int id= Integer.parseInt(request.getParameter("id"));
			UserDAO userDAO = new UserDAO();
			userDAO.edit(id, nombres, apellidos);
			acceso=index;
		}
		
		else if (accion.equals("eliminar")) {
			String idString = request.getParameter("id");
			int id = Integer.parseInt(idString);
			UserDAO userDAO = new UserDAO();
			userDAO.delete(id);
			acceso=index;
		}
		
		else {
			acceso=index;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(acceso);
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
