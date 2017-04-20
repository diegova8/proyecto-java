package cr.ac.ucenfotec.sistemajudicial.datamanagment;


import cr.ac.ucenfotec.sistemajudicial.classes.*;
import cr.ac.ucenfotec.sistemajudicial.accesodb.*;

import java.sql.*;
import java.util.*;
import java.time.LocalDate;

public class MultiCaso {
	
	//F1 . Insert
	public  Caso crear			(String descripcion, Querellante quellerarte, Juez juez)	throws Exception{
		//New object Caso
		Caso Caso = null;
		//New result set
		ResultSet rs;
		//Data
		String id_querellarte 	= "" + quellerarte.getID();
		String id_juez 			= "" + juez.getID();
		String estado 			= "Recibido";
		LocalDate now			= LocalDate.now();
		String fecha			= now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth();
		String historial		= fecha + " - " + estado;
		String sql;
		sql 	= 	"INSERT INTO caso "
				+	"(descripcion, id_querellante, id_juez, estado, fecha, historial) "	
				+	"VALUES ('"+descripcion+"','"+id_querellarte+"','"+id_juez+"','"+estado+"','"+fecha+"','"+historial+"');";
		try {
			//The SQL query is executed
			Conector.getConector().ejecutarSQL(sql);
			//The id is got from the DataBase
			sql = "SELECT MAX(ID) AS 'ID' FROM caso";
			rs = Conector.getConector().ejecutarSQL(sql, true);
			if (rs.next()) {
				//The ID is obtained
				int id = rs.getInt ("ID");
				//Caso object is created
				Caso = new Caso (id, descripcion, quellerarte, juez, historial);
			}
		}
		catch (Exception e) {
			throw new Exception ("Error. Este caso ya se encuentra en el sistema");			
		}
		rs.close();
		return Caso;
	}
	//F2 . Find
	public  Caso buscarPorID 	(int id) 		throws SQLException,Exception{
		//New object Caso
		Caso Caso = null;
		//New result set
		ResultSet rs;
		//SQL query
		String sql;
		sql 	= 	"SELECT * FROM caso "
				+	"WHERE ID = " + id;
		//The SQL query is executed
		rs = Conector.getConector().ejecutarSQL(sql, true);
		if (rs.next()) {
			//Fecha 
			LocalDate fecha = LocalDate.parse(rs.getString("fecha"));
			
			//El caso se almacena en un objeto y se retorna
			Caso = new Caso (id, 
							 rs.getString("descripcion"), 
							 rs.getInt("id_querellante"),
							 rs.getInt("id_juez"),
							 rs.getString("estado"),
							 fecha,
							 rs.getString("historial"));
		} else {
			throw new Exception ("Error. El Caso buscado no existe");			
		}
		rs.close();
		return Caso;		
	}
	//F3 . Actualizar
	public  void actualizar		(Caso pCaso) 	throws SQLException,Exception{
		String sql;
		sql = 	"UPDATE caso "
				+	"SET descripcion='"	+	pCaso.getDescripcion()		+ "', "
				+	"estado='"			+	pCaso.getEstado()			+ "', "
				+	"historial='"		+	pCaso.getHistorial()		+ "' "
				+	"WHERE id="			+	pCaso.getID();
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("Error. El Caso no está registrado.");
		}
	}
	//F4 . Borrar
	public  void borrar			(Caso pCaso) 	throws SQLException,Exception{
		String sql;
		sql = 	"DELETE FROM caso "
				+	"WHERE id="		+	pCaso.getID();
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("Error. Error durante la ejecucion");
		}
	}
	//F5 . Listar
	public  Vector<Caso> listarCasosPorJuez 		(Juez juez) throws SQLException,Exception{
		//New object Caso
		Caso Caso = null;
		//New vector
		Vector<Caso> vector = new Vector<Caso>();		
		//New result set
		ResultSet rs;
		//SQL query
		String sql;
		sql 	= 	"SELECT * FROM caso "
				+	"WHERE id_juez = " + juez.getID();
		//The SQL query is executed
		rs = Conector.getConector().ejecutarSQL(sql, true);
		try {
			while (rs.next()) {
				//Fecha 
				LocalDate fecha = LocalDate.parse(rs.getString("fecha"));
				
				//El caso se almacena en un objeto y se retorna
				Caso = new Caso (rs.getInt("id"), 
								 rs.getString("descripcion"), 
								 rs.getInt("id_querellante"),
								 rs.getInt("id_juez"),
								 rs.getString("estado"),
								 fecha,
								 rs.getString("historial"));
				vector.add(Caso);
			}
		}
		catch (Exception e) {
			throw new Exception ("El Caso no está registrado.");
		}
		rs.close();		
		return vector;
	}
	public  Vector<Caso> listarCasosPorQuerellante 	(Querellante querellante) throws SQLException,Exception{
		//New object Caso
		Caso Caso = null;
		//New vector
		Vector<Caso> vector = new Vector<Caso>();		
		//New result set
		ResultSet rs;
		//SQL query
		String sql;
		sql 	= 	"SELECT * FROM caso "
				+	"WHERE id_querellante = " + querellante.getID();
		//The SQL query is executed
		rs = Conector.getConector().ejecutarSQL(sql, true);
		try {
			while (rs.next()) {
				//Fecha 
				LocalDate fecha = LocalDate.parse(rs.getString("fecha"));
				
				//El caso se almacena en un objeto y se retorna
				Caso = new Caso (rs.getInt("id"), 
								 rs.getString("descripcion"), 
								 rs.getInt("id_querellante"),
								 rs.getInt("id_juez"),
								 rs.getString("estado"),
								 fecha,
								 rs.getString("historial"));
				vector.add(Caso);
			}
		}
		catch (Exception e) {
			throw new Exception ("El Caso no está registrado.");
		}
		rs.close();		
		return vector;
	}
	
}
