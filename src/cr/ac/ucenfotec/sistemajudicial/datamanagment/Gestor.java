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
	public void casoAgregar (String descripcion, Querellante quellerarte, Juez juez) throws Exception {
		Caso caso;
		caso = (new MultiCaso()).crear(descripcion, quellerarte, juez);
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
		LocalDate now			= LocalDate.now();
		String fecha			= caso.getFecha().getYear() + "/" + caso.getFecha().getMonthValue() + "/" + caso.getFecha().getDayOfMonth();
		
		//Data storage
		data.put("id",					"" + caso.getID());
		data.put("descripcion", 		caso.getDescripcion());
		data.put("id_querellante", 		"" + caso.getidQuellerarte());
		data.put("id_juez", 			"" + caso.getidJuez());
		data.put("estado", 				caso.getEstado());
		data.put("fecha", 				fecha);
		data.put("historial", 			caso.getHistorial());
		
		
		return data;
	}

	/**======================================================================
	 * 
	 * 	Juez - Gestor de multis
	 * 
	 **===================================================================**/
	
	/**======================================================================
	 * 
	 * 	Querellante - Gestor de multis
	 * 
	 **===================================================================**/
	
}
