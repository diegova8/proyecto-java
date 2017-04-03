package cr.ac.ucenfotec.sistemajudicial.classes;

import java.util.*;
import java.time.*;

public class Caso {
	private int 		ID;
	private String 		numero;
	private String 		descripcion;
	private Quellerarte quellerarte;
	private Juez 		juez;
	private Estado 		estado;
	private LocalDate 	fecha;
	private ArrayList	historial;
}
