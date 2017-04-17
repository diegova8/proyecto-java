package cr.ac.ucenfotec.sistemajudicial.datamanagment;

import cr.ac.ucenfotec.sistemajudicial.accesodb.*;
import cr.ac.ucenfotec.sistemajudicial.classes.*;

import java.sql.*;

public class MultiQuerellante {
	
	public Querellante crear(String pCedula, String pNombre, String pApellidos, String pTelefono, String pDireccion) throws java.sql.SQLException, Exception {
	
		Querellante querellante = null;
		String sql;
		java.sql.ResultSet rs;
		
		sql = "INSERT INTO querellante "+
				"(cedula, nombre, apellidos, telefono, direccion)"+
				"VALUES ('"+pCedula+"', '"+pNombre+"', '"+pApellidos+"','"+pTelefono+"', '"+pDireccion+"');";
		
		try {
			Conector.getConector().ejecutarSQL(sql);
			sql = "SELECT MAX(ID) AS 'ID' FROM querellarte";
			rs = Conector.getConector().ejecutarSQL(sql, true);
			
			if (rs.next()) {
				int id = rs.getInt ("ID");
				querellante = new Querellante(id, pCedula, pNombre, pApellidos, pTelefono, pDireccion);
			}

		}
		catch(Exception e) {
			throw new Exception ("El querellante ya se encuentra en el sistema");
		}
		rs.close();
		return querellante;
	}
	
	public Querellante buscar(String pCedula) throws java.sql.SQLException, Exception {
		
		Querellante querellante = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT cedula, nombre, apellidos, telefono, direccion "+
				"From querellante "+
				"WHERE cedula='"+pCedula+"';";
		
		rs = Conector.getConector().ejecutarSQL(sql, true);
		
		if(rs.next()){
			querellante = new Querellante(rs.getInt("id"),
					rs.getString("cedula"), 
					rs.getString("nombre"), 
					rs.getString("apellidos"),
					rs.getString("telefono"),
					rs.getString("direccion"));
		} else {
			throw new Exception("El querellante no esta registrado");
		}
		rs.close();
		return querellante;
	}
	
	public void actualizar(Querellante pQuerellante) throws java.sql.SQLException, Exception {
		
		String sql;
		sql = "UPDATE querellante "+
				"SET cedula='"+pQuerellante.getCedula()+"', "+
				"nombre='"+pQuerellante.getNombre()+"', "+
				"apellidos='"+pQuerellante.getApellidos()+"', "+
				"telefono='"+pQuerellante.getTelefono()+"', "+
				"direccion='"+pQuerellante.getDireccion()+"';";
		
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El querellante no esta registrado");
		}
		
	}
	
	public void borrar(Querellante pQuerellante) throws java.sql.SQLException, Exception {
		
		String sql;
		sql = "DELETE FROM querellante "+
		"WHERE id = '"+pQuerellante.getID()+"';";
		
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El querellante tiene casos abiertos");
		}
	}
}	