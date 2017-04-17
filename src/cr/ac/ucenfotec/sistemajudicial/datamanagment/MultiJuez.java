package cr.ac.ucenfotec.sistemajudicial.datamanagment;

import cr.ac.ucenfotec.sistemajudicial.accesodb.*;
import cr.ac.ucenfotec.sistemajudicial.classes.*;

import java.sql.*;

public class MultiJuez {
	
	public Juez crear(String pCedula, String pNombre, 
			String pApellidos, String pTelefono, 
			String pSala, String pUsuario, String pClave) 	
			throws java.sql.SQLException,Exception {
		
		Juez juez = null;
		String sql;
		java.sql.ResultSet rs;
		
		sql = "INSERT INTO juez " +
		"VALUES ('"+pCedula+"','"
				+pNombre+"','"
				+pApellidos+"','"
				+pTelefono+"','"
				+pSala+"','"
				+pUsuario+"','"
				+pClave+"');";
		
		try {
			
			Conector.getConector().ejecutarSQL(sql);
			sql = "SELECT MAX(ID) AS 'ID' FROM querellarte";
			rs = Conector.getConector().ejecutarSQL(sql, true);
			
			if (rs.next()) {
				int id = rs.getInt ("ID");
				juez = new Juez(id, pCedula, pNombre, pApellidos, pTelefono, pSala, pUsuario, pClave);
			}
			
		}
		catch(Exception e) {
			throw new Exception ("Este juez ya se encuentra en el sistema");
		}
		rs.close();
		return juez;
		
	}

	public Juez buscar(String pCedula) throws java.sql.SQLException, Exception {
		
		Juez juez = null;
		String sql;
		java.sql.ResultSet rs;
		
		sql = "SELECT id, cedula, nombre, apellidos, telefono, sala, usuario, clave " + 
		"FROM juez " +
		"WHERE cedula='"+pCedula+"';";
		
		rs = Conector.getConector().ejecutarSQL(sql, true);
		
		if(rs.next()){
			juez = new Juez(rs.getInt("id"), 
						rs.getString("cedula"), 
						rs.getString("nombre"), 
						rs.getString("apellidos"), 
						rs.getString("telefono"), 
						rs.getString("sala"), 
						rs.getString("usuario"),
						rs.getString("clave"));
		} else {
			throw new Exception ("El juez no esta registrado");
		}
		rs.close();
		
		return juez;
	}
	
	public void actualizar(Juez pJuez) throws java.sql.SQLException, Exception {
		
		String sql;
		sql = "UPDATE juez " +
		"SET cedula='"+pJuez.getCedula()+"', "+
				"nombre='"+pJuez.getNombre()+"', "+
				"apellidos='"+pJuez.getApellidos()+"', "+
				"telefono='"+pJuez.getTelefono()+"', "+
				"sala='"+pJuez.getSala()+"', "+
				"usuario='"+pJuez.getUsuario()+"', "+
				"clave='"+pJuez.getClave()+"';";				
		
		try {
			Conector.getConector().ejecutarSQL(sql);
		} 
		catch (Exception e) {
			throw new Exception ("El juez no esta registrado");
		}
	}
	
	public void borrar(Juez pJuez) throws java.sql.SQLException, Exception {
		
		java.sql.ResultSet rs;
		String sql;
		sql = "DELETE FROM juez "+
		"WHERE id='"+pJuez.getID()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e){
			throw new Exception("El juez tiene casos");
		}
	}
	
}
