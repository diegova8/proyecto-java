package cr.ac.ucenfotec.sistemajudicial.classes;

import java.time.*;


public class Caso {
	private int 		ID;
	private String 		descripcion;
	private int			idQuerellante;
	private Querellante querellante;
	private int 		idJuez;
	private Juez 		juez;
	private String 		estado;
	private LocalDate 	fecha;
	private String		historial;
	
	public enum		enumEstado {
		Recibido, 
		Aceptado, 
		Consulta, 
		Rechazado, 
		Redactado, 
		Resuelto, 
		Revision
	}
	
	
	//Constructor
	public Caso(int iD, String descripcion, Querellante quellerarte, Juez juez, String historial) {
		super();
		ID = iD;
		this.descripcion = descripcion;
		this.querellante = quellerarte;
		this.juez = juez;
		this.estado = enumEstado.Recibido.name();
		this.fecha = LocalDate.now();
		this.historial = historial;
		
	}
	
	public Caso(int iD, String descripcion, int idQuerellante, int idJuez, String estado, LocalDate fecha,
			String historial) {
		super();
		ID = iD;
		this.descripcion = descripcion;
		this.idQuerellante = idQuerellante;
		this.querellante = null;
		this.idJuez = idJuez;
		this.juez = null;
		this.estado = estado;
		this.fecha = fecha;
		this.historial = historial;
	}
	//Getters y Setters
	public int getID() {
		return ID;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public int getidQuellerarte() {
		return idQuerellante;
	}
	/**NOTE: CAMBIO **/
	public Querellante getQuellerarte() {
		if (querellante == null) {
			
		}
		return querellante;
	}
	public int getidJuez() {
		return idJuez;
	}
	/**NOTE: CAMBIO **/
	public Juez getJuez() {
		if (juez == null) {
			
		}
		return juez;
	}
	public String getEstado() {
		return estado;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public String getHistorial() {
		return historial;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setQuellerarte(int idQuellerarte) {
		this.idQuerellante = idQuellerarte;
	}
	public void setQuellerarte(Querellante quellerarte) {
		this.querellante = quellerarte;
	}
	public void setJuez(int idJuez) {
		this.idJuez = idJuez;
	}
	public void setJuez(Juez juez) {
		this.juez = juez;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public void setHistorial(String historial) {
		this.historial = historial;
	}
	//Caso
	@Override
	public String toString() {
		return "=======================================================\nID:\t\t\t" + ID + "\ndescripcion:\t\t\t"
				+ descripcion + "\nquellerarte:\n\t\t\t" + querellante + "\njuez:\n\t\t\t" + juez + "\nestado:\t\t\t"
				+ estado + "\nfecha:\t\t\t" + fecha + "\nhistorial:\t\t\t" + historial
				+ "\n=======================================================";
	}
	
	
	
	
	
	
	
	
	
}
