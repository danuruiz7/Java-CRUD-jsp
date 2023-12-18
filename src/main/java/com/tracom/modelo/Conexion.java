package com.tracom.modelo;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conexion {
	Connection con;
	public Conexion(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba","root","");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return con;
	}
}
