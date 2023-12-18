package com.tracom.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements CRUD {
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	Conexion conex = new Conexion();
	int res;
	String msj;

	@Override
	public List list() {
		List<User> datos = new ArrayList<>();
		String sql = "SELECT * FROM user";
		try {
			con = conex.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setLastname(rs.getString("lastname"));
				datos.add(u);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datos;
	}

	@Override
	public User listarId(int id) {
		String sql = "SELECT * FROM user where id= " + id;
		User u = new User();
		try {
			con = conex.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setLastname(rs.getString("lastname"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public String add(String nombre, String apellido) {
		String sql = "INSERT INTO user(name,lastname) values(?,?)";
		try {
			con = conex.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			res = ps.executeUpdate();
			if (res == 1) {
				msj = "Usuario Agragado";
			} else {
				msj = "Error";
			}

		} catch (Exception e) {
		}
		return msj;
	}

	@Override
	public String edit(int id, String nombre, String apellido) {
		String sql = "UPDATE user SET name=?, lastname=? WHERE id=?";
		try {
			con = conex.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setInt(3, id);
			int res = ps.executeUpdate();
			if (res == 1) {
				return "Usuario Actualizado...!!!";
			} else {
				return "Error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Excepción: " + e.getMessage();
		}
	}

	@Override
	public User delete(int id) {
		String sql = "DELETE FROM user WHERE id = ?";
		try {
			con = conex.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
