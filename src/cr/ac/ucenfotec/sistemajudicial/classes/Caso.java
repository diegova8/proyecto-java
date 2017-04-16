package cr.ac.ucenfotec.sistemajudicial.classes;

import java.util.*;
import java.time.*;

public class Caso {
	private int 		ID;
	private String 		numero;
	private String 		descripcion;
	private Quellerarte quellerarte;
	private Juez 		juez;
	private enum		estado {
		Recibido, 
		Aceptado, 
		Consulta, 
		Rechazado, 
		Redactado, 
		Resuelto, 
		Revision
	}
	private LocalDate 	fecha;
	private String	historial;
	//Constructor
	public Caso() {
		super();
		// TODO Auto-generated constructor stub
	}	
	public Caso(int iD, String numero, String descripcion, Quellerarte quellerarte, Juez juez, LocalDate fecha,
			String historial) {
		super();
		ID = iD;
		this.numero = numero;
		this.descripcion = descripcion;
		this.quellerarte = quellerarte;
		this.juez = juez;
		this.fecha = fecha;
		this.historial = historial;
	}


	//Getters y Setters
	public int getID() {
		return ID;
	}
	public String getNumero() {
		return numero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Quellerarte getQuellerarte() {
		return quellerarte;
	}
	public Juez getJuez() {
		return juez;
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
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setQuellerarte(Quellerarte quellerarte) {
		this.quellerarte = quellerarte;
	}
	public void setJuez(Juez juez) {
		this.juez = juez;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public void setHistorial(String historial) {
		this.historial = historial;
	}
	
	
	
	
	
}
