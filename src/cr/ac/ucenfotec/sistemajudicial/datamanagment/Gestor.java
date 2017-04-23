package cr.ac.ucenfotec.sistemajudicial.datamanagment;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;


import cr.ac.ucenfotec.sistemajudicial.classes.*;

public class Gestor {
	
	/**======================================================================
	 * 
	 * 	Caso - Gestor de multis
	 * 
	 **===================================================================**/
	/** Create **/
	public void casoAgregar (String descripcion, int idQuerellante, int idJuez) throws Exception {
		Caso caso;
		Querellante querellante	= (new MultiQuerellante()).buscarPorID(idQuerellante);
		Juez juez				= (new MultiJuez()).buscarPorID(idJuez);
		
		caso = (new MultiCaso()).crear(descripcion, querellante, juez);
	}
	/** Find **/
	public TreeMap<String, String> casoBuscarPorID (int id) throws SQLException, Exception {
		//New Caso Object
		Caso caso	=	null;
		//New TreeMap
		TreeMap<String, String> data = new TreeMap<String, String> ();
		//The object is got
		caso = (new MultiCaso()).buscarPorID(id);
		//Date Format
		String fecha			= caso.getFecha().getYear() + "/" + caso.getFecha().getMonthValue() + "/" + caso.getFecha().getDayOfMonth();
		
		//Data storage
		data.put("id",					"" + caso.getID());
		data.put("descripcion", 		caso.getDescripcion());
		data.put("id_querellante", 		"" + caso.getidQuellerarte());
		data.put("id_juez", 			"" + caso.getidJuez());
		data.put("estado", 				caso.getEstado().val());
		data.put("fecha", 				fecha);
		data.put("historial", 			caso.getHistorial());
		
		
		return data;
	}
	public Vector<TreeMap<String,String>> listarCasosPorJuez (int id) throws SQLException, Exception {
		
		Vector <Caso> casos = (new MultiCaso()).listarCasosPorJuezID(id);
		
		Vector<TreeMap<String,String>> casosTM = new Vector<TreeMap<String,String>>();
		
		for (Caso caso : casos) {//New Caso Object
			//New TreeMap
			TreeMap<String, String> data = new TreeMap<String, String> ();
			//Date Format
			String fecha			= caso.getFecha().getYear() + "/" + caso.getFecha().getMonthValue() + "/" + caso.getFecha().getDayOfMonth();
			
			//Data storage
			data.put("id",					"" + caso.getID());
			data.put("descripcion", 		caso.getDescripcion());
			data.put("id_querellante", 		"" + caso.getidQuellerarte());
			data.put("id_juez", 			"" + caso.getidJuez());
			data.put("estado", 				caso.getEstado().val());
			data.put("fecha", 				fecha);
			data.put("historial", 			caso.getHistorial());		
			
			casosTM.add(data);
		}
		
		return casosTM;
		
	}
	/**======================================================================
	 * 
	 * 	Juez - Gestor de multis
	 * 
	 **===================================================================**/
	public TreeMap<String, String> loginJuez (String user, String pass) throws SQLException, Exception {
		//New Caso Object
		Juez juez	=	null;
		//New TreeMap
		TreeMap<String, String> data = new TreeMap<String, String> ();
		//The object is got
		juez = (new MultiJuez()).login(user, pass);
		
		//Data storage
		data.put("id",			"" + juez.getID());
		data.put("cedula", 		juez.getCedula());
		data.put("nombre", 		juez.getNombre());
		data.put("apellidos", 	juez.getApellidos());
		data.put("telefono", 	juez.getTelefono());
		data.put("sala", 		juez.getSala());
		
		return data;
	}
	/**======================================================================
	 * 
	 * 	Querellante - Gestor de multis
	 * 
	 **===================================================================**/
	public TreeMap<String, String> loginQuerellante (String cedula) throws SQLException, Exception {
		//New Caso Object
		Querellante querellante	=	null;
		//New TreeMap
		TreeMap<String, String> data = new TreeMap<String, String> ();
		//The object is got
		querellante = (new MultiQuerellante()).login(cedula);
		if (querellante != null) {
			//Data storage
			data.put("id",			"" + querellante.getID());
			data.put("cedula", 		querellante.getCedula());
			data.put("nombre", 		querellante.getNombre());
			data.put("apellidos", 	querellante.getApellidos());
			data.put("telefono", 	querellante.getTelefono());
			data.put("direccion", 	querellante.getDireccion());
		} else {
			data = null;
		}
		return data;
	}
}
