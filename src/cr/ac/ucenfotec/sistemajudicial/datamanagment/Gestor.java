package cr.ac.ucenfotec.sistemajudicial.datamanagment;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	/** List **/
	public String[] getEstados (String ID) throws SQLException, Exception {
		String[] estados = null;
		//se obtiene el valor entero de id
		int enteroID = Integer.parseInt(ID);
		//New Caso Object
		Caso caso	=	null;
		//The object is got
		caso = (new MultiCaso()).buscarPorID(enteroID);
				
		switch (caso.getEstado()) {
			case ACEPTADO:
				estados = new String[] {Estado.ACEPTADO.val(),Estado.REDACTADO.val()};
				break;
			case CONSULTA:
				estados = new String[] {Estado.CONSULTA.val(),Estado.ACEPTADO.val(), Estado.RECHAZADO.val()};
				break;
			case RECHAZADO:
				estados = new String[] {Estado.RECHAZADO.val()};
				break;
			case RECIBIDO:
				estados = new String[] {Estado.RECIBIDO.val(),Estado.ACEPTADO.val(), Estado.CONSULTA.val(), Estado.RECHAZADO.val()};
				break;
			case REDACTADO:
				if (caso.getHistorial().contains(Estado.REVISION.toString())) {
					estados = new String[] {Estado.REDACTADO.val(), Estado.RESUELTO.val()};
				} else {
					estados = new String[] {Estado.REDACTADO.val(), Estado.REVISION.val()};					
				}
				break;
			case RESUELTO:
				estados = new String[] {Estado.RESUELTO.val()};
				break;
			case REVISION:
				estados = new String[] {Estado.REVISION.val(),Estado.REDACTADO.val()};
				break;
		
		}
		
		
		
		return estados;
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
			
			Querellante querellante = (new MultiQuerellante()).buscarPorID(caso.getidQuellerarte());
			data.put("nombreQ", querellante.getNombre() + " " + querellante.getApellidos());
			data.put("id_querellante", 		"" + caso.getidQuellerarte());
			data.put("id_juez", 			"" + caso.getidJuez());
			data.put("estado", 				caso.getEstado().val());
			data.put("fecha", 				fecha);
			data.put("historial", 			caso.getHistorial());		
			
			casosTM.add(data);
		}
		
		return casosTM;
		
	}
	/** Update **/
	public void updateEstado (String ID, String pEstado) throws SQLException, Exception {
		//se obtiene el valor entero de id
		int enteroID = Integer.parseInt(ID);
		//New Caso Object
		Caso caso	=	null;
		//The object is got
		caso = (new MultiCaso()).buscarPorID(enteroID);
		//Estado
		Estado estado = Estado.valueOf(pEstado.toUpperCase());
		//Updates object
		caso.setEstado(estado);
		//Updates history
		LocalDateTime now			= LocalDateTime.now();
		String fecha			= now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth() + " - " + now.getHour() + ":" + now.getMinute();
		
		
		String historial		= caso.getHistorial() + "\n";
		historial 				+= fecha + " - " + estado;
		
		caso.setHistorial(historial);
		//Update DB
		(new MultiCaso()).actualizarEstado(caso);
		
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
