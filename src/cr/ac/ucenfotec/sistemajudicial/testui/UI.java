package cr.ac.ucenfotec.sistemajudicial.testui;


import cr.ac.ucenfotec.sistemajudicial.datamanagment.*;

import java.time.LocalDate;
import java.util.Vector;

import javax.swing.JOptionPane;

import cr.ac.ucenfotec.sistemajudicial.classes.*;

public class UI {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			
		
			Querellante q = new Querellante (2, "116810122", "Gary", "Valverde Hampton", "86013609", "San Sebastian");
			Juez j = new Juez (1, "123", "Juez", "Juez", "88882222", "1", "juez123", "123");
			Caso c =  (new MultiCaso()).buscarPorID(1);
			c.setDescripcion("Caso de violacion");
			c.setEstado("Aceptado");
			LocalDate now			= LocalDate.now();
			String fecha			= now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth();
			
			
			String historial = c.getHistorial() + "\n"
					+ fecha + " - " + c.getEstado();
								
			c.setHistorial(historial);
			(new MultiCaso()).actualizar(c);
			c =  (new MultiCaso()).buscarPorID(1);	
			
			Vector<Caso> casos = (new MultiCaso()).listarCasosPorQuerellante(q);
			
			JOptionPane.showMessageDialog(null, casos.toString());
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "DataBase Connection Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

}
