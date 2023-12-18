package com.tracom.modelo;

import java.util.List;

public interface CRUD {
	public List list();
	public User listarId(int id);
	public String add(String nombre,String apellido);
	public String edit(int id,String nombre,String apellido);
	public User delete(int id);
}
